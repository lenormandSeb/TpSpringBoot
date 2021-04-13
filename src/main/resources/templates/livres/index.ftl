<#include "../header.ftl"/>
<#assign i = items?size>
<h1>Page des ${i} livres !</h1>
<a class="btn btn-success" href="../books/create">Creer un nouveau livre</a>
<div class="row">
<#list items as item>
<div class="col-md-3">
    <div class="card">
        <img class="card-img-top" src="../${item.img}"/>
        <div class="card-body">
            <h5 class="card-title">${item.bookName}</h5>
            <div class="btn-group">
                <a class="btn btn-success">Acheter : ${item.price} €</a>
                <a class="btn btn-warning">Voir la liste des vendeurs</a>
            </div>
        </div>
    </div>
</div>
</#list>
</div>
<#include "../footer.ftl"/>