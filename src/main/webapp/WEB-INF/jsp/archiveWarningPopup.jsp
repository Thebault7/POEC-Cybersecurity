<%@ page contentType="text/html;charset=UTF-8" %>

<div class="modal fade" id="archivePopup" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Confirmer l'archivage</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Etes-vous sûr de vouloir archiver ceci ? <br>
                    Vous n'aurez plus accès à cet élément après archivage.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Non, annuler</button>
                <a href="" type="button" class="btn btn-danger" id="btnDeleteYes">Oui, archiver</a>
            </div>
        </div>
    </div>
</div>
