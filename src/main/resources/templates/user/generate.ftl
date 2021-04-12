<#include "../header.ftl"/>
<#if count = 0>
    <p>Il semblerais qu'il n'y ai pas de donnée !!!</p>
    <p>Si tu as besoin de donnée, appuie sur le bouton qui suit !</p>

    <a class="btn btn-success">C'est celui la le bouton</a>

    <p>Sinon appuie sur le bouton qui suit</p>
    <a class="btn btn-danger" href="../user/donjonDeNaheulbeuk">Je n'ai pas besoin de donnée</a>
<#else>
    <p><i>Il est écris dans les tablettes de Skellox, que seul un gnome des forêts du Nord unijambiste</p>
    <p>dansant à la plaine lune au milieu des douzes statuettes enroulées dans du jambon</p>
    <p>ouvrira la porte de Zaral Bak et permettra l'accomplissement de la <a href="../user/updateData" title="Appuie si tu veux voir l'elfe de niveau 2!!!">prophétie</a></i></p>
</#if>
<#include "../footer.ftl"/>