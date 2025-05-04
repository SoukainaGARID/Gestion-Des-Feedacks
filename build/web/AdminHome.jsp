<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.ProduitService" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.ProduitService" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>




<%
    if (session.getAttribute("email") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<html>
    <!-- HEAD -->
    <head>
        <title>Feed4U - Espace Admin</title>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;700&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@400;600;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
        <!-- Swiper CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />

        <!-- Swiper JS -->
        <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>

        <style>
            * {
                margin: 0; padding: 0;
                box-sizing: border-box;
                font-family: 'Poppins', sans-serif;
            }
            body {
                background-color: #fdf8f5;
                color: #333;
            }

            header {
                background-color: transparent;
                transition: background-color 0.3s ease, box-shadow 0.3s ease;

                padding: 40px 50px;
                display: flex;
                justify-content: space-between;
                align-items: center;
                position: fixed;
                width: 100%;
                top: 0;
                z-index: 99;
                box-shadow: 0 2px 6px rgba(0, 0, 0, 0.05);
                height: 120px; 
            }
            header.scrolled {
                background-color: #f5e9e1;
                box-shadow: 0 2px 6px rgba(0, 0, 0, 0.05);
            }

            header img {
                height: 180px;
                margin-right: 0px;
            }

            nav a {
                margin: 0 20px;
                text-decoration: none;
                color: #e08c68;
                font-weight: 500;
                transition: color 0.3s;
            }

            nav a:hover {
                color: wheat;
            }

            nav a.logout {
                color: #e74c3c;
                font-weight: bold;
                padding: 8px 16px;
                border: 2px solid #e74c3c;
                border-radius: 8px;
                background-color: transparent;
                transition: all 0.3s ease;
                text-decoration: none;
                font-size: 0.95em;
                display: inline-flex;
                align-items: center;
                gap: 8px;
            }

            nav a.logout:hover {
                background-color: #e74c3c;
                color: white;
            }

            nav a.logout i {
                font-size: 1em;
            }
            #admin-accueil {
                background: url('images/bgAdmin.png') no-repeat right center;
                background-size: cover;
                background-position: center;
                min-height: 100vh;
                padding: 0 10%;
                display: flex;
                align-items: center;
                justify-content: space-between;
                border-bottom-left-radius: 0px;
                color: white;
                text-shadow: 1px 1px 2px #00000055;
                padding-top: 150px;

            }
            .admin-welcome-content {
                max-width: 50%;
                color: #222;
            }

            #admin-accueil h1 {
                font-family: 'Playfair Display', serif;
                font-size: 3.5em;
                font-weight: 700;
                color: #333;
                margin-bottom: 20px;
            }

            #admin-accueil p {
                font-family: 'Poppins', sans-serif;
                font-size: 1.1em;
                color: #5c4033;
                margin-bottom: 30px;
            }

            .admin-btn {
                background-color: #e08c68;
                color: white;
                padding: 12px 24px;
                text-decoration: none;
                border-radius: 8px;
                font-weight: 500;
                transition: background-color 0.3s ease;
            }

            .admin-btn:hover {
                background-color: #d07550;
            }

            #listproducts {
                height: 70vh; /* demi-page */
                overflow-y: auto;
                padding: 40px 10%;
                background-color: #fff3eb;
            }

            #listproducts h2,
            #stats h2 {
                font-size: 2em;
                margin-bottom: 30px;
                color: #333;
                font-family: 'Playfair Display', serif;
            }

            .product-grid {
                display: grid;
                grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
                gap: 20px;
            }

           



            .delete-btn {
                color: #e74c3c;
            }

            .edit-btn {
                color: #3498db;
            }

            .product-card {
                background-color: #fff;
                border: 1px solid #eee;
                border-radius: 16px;
                padding: 20px;
                box-shadow: 0 4px 8px rgba(0,0,0,0.05);
                transition: transform 0.2s ease;
                position: relative;
                flex-direction: column;
                justify-content: space-between;
                max-height: 90%;
                overflow: auto;
                padding-top: 40px; /* Pour laisser la place aux icônes */
                width: 90%; /* ou 100% si tu veux qu’elle prenne toute la largeur du slide */
                max-width: 400px;
                height: 100%;
                display: flex;


            }

            .product-card:hover {
                transform: translateY(-5px);
                 box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
            }

            .product-card h3 {
                margin-bottom: 10px;
                color: #e08c68;
            }

            .product-card p {
                margin-bottom: 8px;
                font-size: 0.95em;
            }

            .product-card button {
                background-color: #e08c68;
                color: white;
                border: none;
                padding: 10px 16px;
                border-radius: 8px;
                cursor: pointer;
                font-weight: 500;
            }
.product-card h3 {
    color: #d67150;
    font-weight: bold;
    margin-bottom: 8px;
}
.product-card p {
    margin: 5px 0;
}
.product-card em {
    display: block;
    margin-bottom: 10px;
    color: #5f5f5f;
}
            .product-card button:hover {
                background-color: #d07550;
            }

            .empty-message {
                text-align: center;
                font-size: 1.1em;
                color: #999;
            }

            #stats {
                padding: 60px 10%;
                background-color: #fdf8f5;
            }

            .chart-container {
                background-color: white;
                padding: 20px;
                border-radius: 12px;
                box-shadow: 0 4px 8px rgba(0,0,0,0.05);
            }
            #ajout-produit {
                background-color: #fff7f2;
                padding: 60px 10%;
                border-top: 1px solid #e6dcd6;
            }

            #ajout-produit h2 {
                font-family: 'Playfair Display', serif;
                font-size: 2em;
                margin-bottom: 30px;
                color: #333;
            }

            .form-produit {
                display: grid;
                grid-template-columns: 1fr 1fr;
                gap: 20px;
            }

            .form-produit .form-group {
                display: flex;
                flex-direction: column;
            }

            .form-produit label {
                margin-bottom: 5px;
                font-weight: 500;
                color: #555;
            }

            .form-produit input,
            .form-produit select,
            .form-produit textarea {
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 8px;
                font-size: 0.95em;
                font-family: 'Poppins', sans-serif;
            }

            .form-produit textarea {
                resize: vertical;
                min-height: 80px;
            }

            .form-produit button {
                grid-column: span 2;
                width: fit-content;
                padding: 12px 24px;
                background-color: #e08c68;
                border: none;
                color: white;
                font-weight: 500;
                border-radius: 8px;
                cursor: pointer;
                margin-top: 20px;
                transition: background-color 0.3s ease;
            }

            .form-produit button:hover {
                background-color: #d07550;
            }

            .success-message {
                background-color: #dff0d8;
                color: #3c763d;
                border: 1px solid #d6e9c6;
                padding: 12px 20px;
                margin: 20px 0;
                border-radius: 8px;
                font-weight: 500;
            }
            .modal {
                position: fixed;
                z-index: 999;
                left: 0; top: 0;
                width: 100%; height: 100%;
                background-color: rgba(0, 0, 0, 0.4);
                display: flex; justify-content: center; align-items: center;
            }

            .modal-content {
                background: white;
                padding: 30px;
                border-radius: 12px;
                width: 600px;
                max-width: 90%;
                position: relative;
                animation: fadeIn 0.3s ease-in-out;
            }

            .close {
                position: absolute;
                top: 15px; right: 20px;
                font-size: 1.5em;
                cursor: pointer;
            }

            @keyframes fadeIn {
                from { opacity: 0; transform: scale(0.95); }
                to { opacity: 1; transform: scale(1); }
            }
            .swiper-slide {
                display: flex;
                justify-content: center;
            }

            #dashboard {
                padding: 60px 10%;
                background-color: #fdf8f5;
            }

            #dashboard h2 {
                font-size: 2em;
                margin-bottom: 30px;
                font-family: 'Playfair Display', serif;
                color: #333;
            }

            .dashboard-widgets {
                display: flex;
                gap: 20px;
                flex-wrap: wrap;
                justify-content: space-between;
            }

            .widget {
                flex: 1 1 30%;
                background-color: #fff;
                border-radius: 12px;
                padding: 20px;
                box-shadow: 0 4px 10px rgba(0,0,0,0.05);
                display: flex;
                align-items: center;
                gap: 16px;
                transition: transform 0.3s ease;
            }

            .widget:hover {
                transform: translateY(-5px);
            }

            .widget i {
                font-size: 2em;
                color: #e08c68;
            }

            .widget div span {
                display: block;
                font-weight: 500;
                color: #555;
            }

            .widget div h3 {
                margin: 5px 0 0;
                font-size: 1.8em;
                color: #333;
            }
            
            .feedback-list {
    margin-top: 10px;
    padding: 12px 16px;
    background-color: #fefefe;
    border: 1px solid #eee;
    border-radius: 10px;
    box-shadow: 0 2px 6px rgba(0,0,0,0.05);
}

.feedback-list h4 {
    margin-bottom: 10px;
    color: #333;
    font-weight: 600;
}

.feedback-item {
    border-bottom: 1px solid #eee;
    padding: 8px 0;
    font-size: 0.95em;
    color: #444;
}

.feedback-item:last-child {
    border-bottom: none;
}

.feedback-note {
    color: #e08c68;
    font-weight: bold;
    margin-left: 10px;
}

.card-actions {
    position: absolute;
    top: 12px;
    right: 12px;
    display: flex;
    gap: 10px;
}

.icon-btn {
    background: none !important;
    border: none !important;
    box-shadow: none !important;
    padding: 4px !important;
    color: #e08c68 !important;
    font-size: 1.1em !important;
    cursor: pointer !important;
    transition: color 0.3s ease;
    border-radius: 6px;
}

.icon-btn:hover {
    color: #c96f4c !important;
    background-color: rgba(224, 140, 104, 0.1) !important;
}





        </style>
    </head>

    <body>

        <header>
            <div style="display: flex; align-items: center;">
                <img src="images/logo.png" alt="Feed4U Logo">
            </div>
            <nav>
                <a href="#admin-accueil">Accueil</a>
                <a href="#listproducts">Produits</a>
                <a href="#stats">Statistiques</a>
                <a class="logout" href="DeconnexionController">
                    <i class="fas fa-sign-out-alt"></i> Se déconnecter
                </a>
            </nav>
        </header>

        <section id="admin-accueil">
            <div class="admin-welcome-content">
                <h1>Bienvenue, Administrateur</h1>
                <p>Gérez les produits, visualisez les statistiques et accédez à tous les feedbacks utilisateurs en un seul endroit.</p>
                <a href="#listproducts" class="admin-btn">Commencer</a>
            </div>
        </section>


        <!-- SECTION DASHBOARD -->
        <section id="dashboard" style="padding: 60px 10%;">
            <h2>Tableau de bord</h2>
            <div style="display: flex; gap: 30px; flex-wrap: wrap;">
                <div style="background: white; padding: 30px 40px; border-radius: 20px; box-shadow: 0 4px 10px rgba(0,0,0,0.05); flex: 1; min-width: 220px;">
                    <i class="fas fa-box" style="color: #e08c68; font-size: 1.8em;"></i>
                    <p style="font-weight: bold; margin-top: 10px;">Total Produits</p>
                    <h3 style="font-size: 2em; margin-top: 5px;">${totalProduits}</h3>
                </div>

                <div style="background: white; padding: 30px 40px; border-radius: 20px; box-shadow: 0 4px 10px rgba(0,0,0,0.05); flex: 1; min-width: 220px;">
                    <i class="fas fa-comments" style="color: #e08c68; font-size: 1.8em;"></i>
                    <p style="font-weight: bold; margin-top: 10px;">Total Feedbacks</p>
                    <h3 style="font-size: 2em; margin-top: 5px;">${totalFeedbacks}</h3>
                </div>


            </div>
        </section>



        <%-- Message de succès --%>
        <c:if test="${param.msg == 'success'}">
            <div class="success-message">Produit ajouté avec succès !</div>
        </c:if>
        <c:if test="${param.msg == 'modif'}">
            <div class="success-message">Produit modifié avec succès !</div>
        </c:if>
        <c:if test="${param.msg == 'error'}">
            <div class="success-message" style="background-color: #f2dede; color: #a94442;">Erreur lors de la modification.</div>
        </c:if>





        <!-- SECTION  PRODUITS -->
        <section id="listproducts">
            <h2>Nos Produits</h2>

            <c:if test="${not empty produits}">
                <div class="swiper mySwiper">
                    <div class="swiper-wrapper">
                        <c:forEach items="${produits}" var="p">
                            <div class="swiper-slide">
                                <div class="product-card" style="position: relative;">
                                    <div class="card-actions">
                                        <form action="SupprimerProduit" method="post" onsubmit="return confirm('Supprimer ce produit ?')">
                                            <input type="hidden" name="id" value="${p.idProduit}" />
                                            <button type="submit" class="icon-btn delete-btn" title="Supprimer">
                                                <i class="fas fa-trash-alt"></i>
                                            </button>
                                        </form>
                                        <button type="button" class="icon-btn edit-btn" title="Modifier"
                                                onclick="openEditModal(
                                                ${p.idProduit},
                                                                    '${fn:replace(fn:escapeXml(p.nom), "'", "\\'")}',
                                                                    '${fn:replace(fn:escapeXml(p.type), "'", "\\'")}',
                                                                    '${fn:replace(fn:escapeXml(p.description), "'", "\\'")}',
                                                ${p.categorie.id}
                                                            )">
                                            <i class="fas fa-edit"></i>
                                        </button>
                                    </div>

                                    <h3>${p.nom}</h3>
                                    <p><strong>Type :</strong> ${p.type}</p>
                                    <p><em>${p.description}</em></p>
                                    <p><strong>Catégorie :</strong> ${p.categorie.nom}</p>

                                    <button onclick="loadFeedbacks(${p.idProduit})" class="admin-btn" style="margin-top: 10px;">
                                        Voir feedbacks
                                    </button>
                                    <div id="feedbacks-${p.idProduit}"></div>


                                </div>


                            </div>
                        </c:forEach>
                    </div>

                    <!-- Swiper navigation buttons -->
                    <div class="swiper-button-prev"></div>
                    <div class="swiper-button-next"></div>
                    <div class="swiper-pagination"></div>
                </div>

            </c:if>

            <c:if test="${empty produits}">
                <p class="empty-message">Aucun produit trouvé.</p>
            </c:if>
        </section>



        <!-- SECTION AJOUT PRODUIT -->
        <section id="ajout-produit">
            <h2>Ajouter un produit</h2>
            <form action="AdminHome" method="post" class="form-produit">
                <div class="form-group">
                    <label>Nom :</label>
                    <input type="text" name="nom" required>
                </div>
                <div class="form-group">
                    <label>Type :</label>
                    <input type="text" name="type" required>
                </div>
                <div class="form-group">
                    <label>Description :</label>
                    <textarea name="description" rows="3" required></textarea>
                </div>
                <div class="form-group">
                    <label>Catégorie :</label>
                    <select name="categorie" required>
                        <c:forEach items="${categories}" var="cat">
                            <option value="${cat.id}">${cat.nom}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="admin-btn">Ajouter</button>
            </form>
        </section>



        <!-- SECTION STATS -->
        <section id="stats">
            <h2>Statistiques : Notes moyennes</h2>
            <div class="chart-container">
                <canvas id="barChart" width="600" height="300"></canvas>
            </div>
        </section>

        <div id="editModal" class="modal" style="display:none;">
            <div class="modal-content">
                <span class="close" onclick="closeEditModal()">&times;</span>
                <h2>Modifier le produit</h2>
                <form action="ModifierProduit" method="post" class="form-produit">
                    <input type="hidden" name="id" id="editId">

                    <div class="form-group">
                        <label>Nom :</label>
                        <input type="text" name="nom" id="editNom" required>
                    </div>
                    <div class="form-group">
                        <label>Type :</label>
                        <input type="text" name="type" id="editType" required>
                    </div>
                    <div class="form-group">
                        <label>Description :</label>
                        <textarea name="description" id="editDescription" required></textarea>
                    </div>
                    <div class="form-group">
                        <label>Catégorie :</label>
                        <select name="categorie" id="editCategorie" required>
                            <c:forEach items="${categories}" var="cat">
                                <option value="${cat.id}">${cat.nom}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <button type="submit" class="admin-btn">Mettre à jour</button>
                </form>
            </div>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <script>
                            const labels = [];
                            const data = [];
            <c:forEach items="${notesMoyennes}" var="entry">
                    labels.push("${entry.key}");
                            data.push(${entry.value});
            </c:forEach>

                    new Chart(document.getElementById('barChart'), {
                    type: 'bar',
                            data: {
                            labels: labels,
                                    datasets: [{
                                    label: 'Note moyenne',
                                            data: data,
                                            backgroundColor: 'rgba(54, 162, 235, 0.6)'
                                    }]
                            },
                            options: {
                            scales: {
                            y: {
                            beginAtZero: true,
                                    max: 10
                            }
                            }
                            }
                    });</script>
        <!-- SCRIPT AJAX FEEDBACK -->

        <script>
                    function loadFeedbacks(produitId) {
                    const container = document.getElementById("feedbacks-" + produitId);
                            // Toggle affichage
                            if (container.innerHTML.trim() !== "") {
                    container.innerHTML = ""; // masquer si déjà affiché
                            return;
                    }

                    fetch("getFeedbacksAjax?id=" + produitId)
                            .then(response => response.text())
                            .then(html => {
                            container.innerHTML = html;
                            })
                            .catch(error => {
                            container.innerHTML = "<p>Erreur de chargement des feedbacks.</p>";
                                    console.error(error);
                            });
                    }
        </script>

        <script>
            window.addEventListener("scroll", function () {
            const header = document.querySelector("header");
                    if (window.scrollY > 50) {
            header.classList.add("scrolled");
            } else {
            header.classList.remove("scrolled");
            }
            });</script>
        <script>
                    setTimeout(() = > {
                    const msg = document.querySelector(".success-message");
                            if (msg) {
                    msg.style.transition = "opacity 1s ease";
                            msg.style.opacity = 0;
                            setTimeout(() = > msg.remove(), 1000);
                    }
                    }, 3000);</script>
        <script>
                    function openEditModal(id, nom, type, description, categorieId) {
                    document.getElementById('editId').value = id;
                            document.getElementById('editNom').value = nom;
                            document.getElementById('editType').value = type;
                            document.getElementById('editDescription').value = description;
                            document.getElementById('editCategorie').value = categorieId;
                            document.getElementById('editModal').style.display = 'flex';
                    }

            function closeEditModal() {
            document.getElementById('editModal').style.display = 'none';
            }

            window.onclick = function(event) {
            const modal = document.getElementById('editModal');
                    if (event.target === modal) {
            modal.style.display = "none";
            }
            }
        </script>
        <script>
            const swiper = new Swiper('.mySwiper', {
            slidesPerView: 1,
                    spaceBetween: 30,
                    loop: true,
                    pagination: {
                    el: '.swiper-pagination',
                            clickable: true,
                    },
                    navigation: {
                    nextEl: '.swiper-button-next',
                            prevEl: '.swiper-button-prev',
                    },
                    breakpoints: {
                    768: {
                    slidesPerView: 2,
                    },
                            1024: {
                            slidesPerView: 3,
                            }
                    }
            });

        </script>

    </body>
</html>
