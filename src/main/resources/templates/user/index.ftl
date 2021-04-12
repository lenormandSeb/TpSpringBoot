<#include "../header.ftl"/>
<#assign i = items?size>
<h1>Bienvenue sur la page ${page} des users</h1>
    <div class="table table-responsive">
        <table>
            <thead>
                <th>Nom - Prenom</th>
                <th>Roles</th>
                <th>Nb de livre</th>
                <th>Action</th>
            </thead>
            <tbody>
            <tr>
            <#list items as item>
                <td> ${item.firstName} - ${item.lastName} - ${item.id}</td>
                <td> Customer </td>
                <td> 124 </td>
                <td>
                    <div class="btn-group">
                        <a class="btn btn-info" href="../user/show/${item.id}">Voir</a>
                        <a class="btn btn-warning">Changer de role</a>
                        <a class="btn btn-secondary">Voir les livres</a>
                        <a class="btn btn-danger">Supprimer</a>
                    </div>
                </td>
                </tr>
            </#list>
            </tbody>
            <tfooter>
                <a class="btn btn-success" href="../user/create">Creer un nouveau user</a>
            </tfooter>
        </table>
    </div>

<#include "../footer.ftl"/>