$(function () {
    let counter = 0;

    addProductListener();
    $("#table tbody tr:last").find(".productSelect").change();

    $("#addrow").on("click", function () {
        const newRow = $("<tr>");
        let cols = "";

        const optionList = $("#table").find("tbody tr:first").find(".productSelect option");
        //TODO stocker select.val()

        // cols += '<td><input type="text" class="form-control" name="productsId' + counter + '"/></td>';

        cols += '<td><select class="form-control productSelect" id="product_' + counter + '" name="productsId_' + counter + '">\n';
        optionList.each(function() {
            // if select.val not egal this.val
            cols += '<option value=' + $(this).val() +'>' + $(this).text() + '</option>';
        });
        cols +=    '   </select></td>';

        cols += '<td><input type="number" class="form-control quantityInput" value="1" min="1" step="1" name="quantity' + counter + '"/></td>';
        cols += '<td><input type="text" class="form-control vatInput" readonly name="vat' + counter + '"/></td>';
        cols += '<td><input type="text" class="form-control priceHTInput" readonly name="priceNoTaxes' + counter + '"/></td>';
        cols += '<td><input type="text" class="form-control totalPriceHTInput" readonly name="totalPriceNoTaxes' + counter + '"/></td>';

        cols += '<td><input type="button" class="ibtnDel btn btn-md btn-danger fa fa-input"  value="&#xf056"></td>';
        newRow.append(cols);
        $("table.order-list").append(newRow);
        addProductListener();
        $("#table tbody tr:last").find(".productSelect").change();
        counter++;
    });


    // delete row from table
    $("table.order-list").on("click", ".ibtnDel", function (event) {
        $(this).closest("tr").remove();
        recalculerTotal();
        counter -= 1
    });

});

function addProductListener(){
    $(".productSelect").change(function(event){
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
                recalculerTotal();
            }
        });
    });

    //Réafficher les info si changement de quantité (pour le total)
    $(".quantityInput").change(function(e){
        $(this).closest("tr").find(".productSelect").change();
    });

}

function recalculerTotal(){
    let total = 0;
    $("#table").find("tbody tr").each(function(){
        let totalHT = Number($(this).find(".totalPriceHTInput").val());
        let vat = $(this).find(".vatInput").val();
        total += (totalHT * vat / 100) + totalHT;
    })
    //text() car totalTTC n'est pas un input
    $("#totalTTC").text(total);
}

function calculateRow(row) {
    const price = +row.find('input[name^="price"]').val();

}

function calculateGrandTotal() {
    let grandTotal = 0;
    $("table.order-list").find('input[name^="price"]').each(function () {
        grandTotal += +$(this).val();
    });
    $("#grandtotal").text(grandTotal.toFixed(2));
}