<#include "../header.ftl"/>
<form method="POST">
    <div class="form-group">
        <label for="bookName">Titre</label>
        <input type="text" name="bookName" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="bookName">Nombre de page</label>
        <input type="number" max="1200" min="10" name="nbPage" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="bookName">Prix</label>
        <input type="number" max="1200" min="10" name="price" class="form-control"/>
    </div>
    <div class="form-group">
        <#include "../macro/btnForm.ftl"/>
    </div>
</form>
<#include "../footer.ftl"/>