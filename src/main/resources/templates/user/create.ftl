<#include "../header.ftl"/>
<h2>Creation d'un nouvel utilisateur</h2>
<form>
    <div class="form-group">
        <label for="firstName">Firstname</label>
        <input class="form-control" type="text" placeholder="firstname" name="firstName"/>
    </div>
    <div class="form-group">
        <label for="lastName">Lastname</label>
        <input class="form-control" type="text" placeholder="lastName" name="lastName"/>
    </div>
    <div class="form-group">
        <label for="role">Role</label>
        <select name="role" class="form-control">
            <option value="0">No Role</option>
            <#list roles as role>
                <option value="${role.id}">${role.roleName}</option>
            </#list>
        </select>
    </div>
    <div class="form-group">
        <div class="btn-group">
            <button class="btn btn-success">Valider</button>
            <button class="btn btn-danger">Annuler</button>
        </div>
    </div>
</form>
<#include "../footer.ftl"/>