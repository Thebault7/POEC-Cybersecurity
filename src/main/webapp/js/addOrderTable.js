$(function () {
    let counter = 1;

    addProductListener();
    $("#table tbody tr:last").find(".productSelect").change();

    $("#addrow").on("click", function () {
        const newRow = $("<tr>");
        let cols = "";
        const optionList = $("#table").find("tbody tr:first").find(".productSelect option");

        // option list is modified accordidng to what is already selected in other rows
        const selectedOptions = $("#table tbody").find("tr .productSelect option:selected");
        let selectedOptionsVal = [];
        selectedOptions.each(function () {
            selectedOptionsVal.push($(this).val());
        })

        cols += '<td><select class="form-control productSelect" id="product_' + counter + '" name="productId_' + counter + '">\n';
        optionList.each(function() {
            const newOptionVal = $(this).val();
            const newOptionText = $(this).text();
            if (!selectedOptionsVal.includes(newOptionVal)) {
                cols += '<option value=' + newOptionVal +'>' + newOptionText + '</option>';
            }
        });
        cols +=    '   </select></td>';

        cols += '<td><input type="number" class="form-control quantityInput" value="1" min="1" step="1" name="quantity_' + counter + '"/></td>';
        cols += '<td><input type="text" class="form-control vatInput" readonly name="vat_' + counter + '"/></td>';
        cols += '<td><input type="text" class="form-control priceHTInput" readonly name="priceNoTaxes_' + counter + '"/></td>';
        cols += '<td><input type="text" class="form-control totalPriceHTInput" readonly name="totalPriceNoTaxes_' + counter + '"/></td>';

        cols += '<td><input type="button" class="ibtnDel btn btn-md btn-danger fa fa-input"  value="&#xf056"></td>';
        newRow.append(cols);
        $("table.order-list").append(newRow);
        addProductListener();
        $("#table tbody tr:last").find(".productSelect").change();
        counter++;
    });

    // delete row from table
    $("table.order-list").on("click", ".ibtnDel", function (event) {
        
        const row = $(this).closest("tr");
        const tr = row[0];
        const val = row.find(".productSelect option:selected").val();
        const text = row.find(".productSelect option:selected").text();
        addOptionToOtherLists(tr, val, text);
        $(this).closest("tr").remove();
        recalculateTotal();
        counter -= 1
    });

});

function addOptionToOtherLists(tr, val, text){
    if(tr === ""){
        return;
    }
    const rows = $("#table tbody tr");
    rows.each(function(){
        const row = $(this);
        if(row[0] !== tr){
            row.find(".productSelect").append(new Option(text,val));
        }
    });
}

function deleteOptionToOtherLists(tr){
    const optionVal = tr.find(".productSelect option:selected").val();
    const rows = $("#table tbody tr");
    rows.each(function(){
        if($(this)[0] !== tr[0]){
            $(this).find(".productSelect option[value="+ optionVal +"]").remove();
        }
    });
}

function addProductListener(){
    $(".productSelect").change(function(event){
        const previousTr = $(this).prop('data-oldTr') !== undefined ? $(this).prop('data-oldTr') : "";
        const previousVal = $(this).prop('data-oldVal') !== undefined ? $(this).prop('data-oldVal') : "";
        const previousText = $(this).prop('data-oldText') !== undefined ? $(this).prop('data-oldText') : "";

        addOptionToOtherLists(previousTr, previousVal, previousText);
        $(this).prop('data-oldTr', $(this).closest("tr")[0]);
        $(this).prop('data-oldVal', $(this).closest("tr").find(".productSelect option:selected").val());
        $(this).prop('data-oldText', $(this).closest("tr").find(".productSelect option:selected").text());
        const productId = $(this).val();
        const tr = $(this).closest("tr");
        $.ajax({
            url: "getSoldProduct",
            type: "GET",
            data: "productId="+productId,
            success: function(data){

                const product = data.product;
                const quantity = tr.find(".quantityInput").val();
                tr.find(".vatInput").val(product.vat.percentage * 100);
                tr.find(".priceHTInput").val(product.price);
                tr.find(".totalPriceHTInput").val(product.price * quantity);
                deleteOptionToOtherLists(tr);
                recalculateTotal();
            }
        });
    });

    // display info if change in quantity (for total)
    $(".quantityInput").change(function(e){
        $(this).closest("tr").find(".productSelect").change();
    });

}

function recalculateTotal(){
    let total = 0;
    $("#table").find("tbody tr").each(function(){
        let totalHT = Number($(this).find(".totalPriceHTInput").val());
        let vat = $(this).find(".vatInput").val();
        total += (totalHT * vat / 100) + totalHT;
    })
    //text() car totalTTC n'est pas un input
    $("#totalTTC").text(total);
}
