<#include "../header.ftl"/>
<h2>Page des roles</h2>
<div class="table table-responsive">
    <table class="table-bordered">
        <thead>
            <th>Nom du Role</th>
            <th>Nombre d'utilisateur / role</th>
            <th>Action</th>
        </thead>
        <tbody>
            <tr>
            <#list items as i>
                <td>${i.roleName}</td>
                <td>
                    <#list roleSeller as key>
                        <#if i.roleName == key.getRoleName()>
                            ${key.getNum()}
                        </#if>
                    </#list>
                </td>
                <td>
                    <a class="btn btn-success" href="../role/show/${i.id}">Voir</a>
                </td>
                </tr>
            </#list>
        </tbody>
        <tfooter>
            <a class="btn btn-success" href="../role/create">Creer un nouveau role</a>
        </tfooter>
    </table>
</div>
<#include "../footer.ftl"/>