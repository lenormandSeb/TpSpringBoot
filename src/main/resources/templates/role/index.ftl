<#include "../header.ftl"/>
<h2>Page des roles ${page} </h2>
<div class="table">
    <table>
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
                    <#if i.roleName == "Seller">
                        ${roleSeller}
                    <#else>
                        ${roleCustomer}
                    </#if>
                </td>
                <td>
                    <a class="btn btn-success">Voir</a>
                </td>
                </tr>
            </#list>
        </tbody>
    </table>
</div>
<#include "../footer.ftl"/>