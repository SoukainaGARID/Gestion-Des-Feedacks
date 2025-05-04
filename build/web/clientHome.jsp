<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.ProduitService" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<%
    if (session.getAttribute("email") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<html>
<head>
    <title>Feed4U - Espace Client</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@400;600;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@600&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">


    <style>
        * {
            margin: 0;
            padding: 0;
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
            color: #1d1d1d;
            font-weight: 500;
            transition: color 0.3s;
        }
        nav a:hover {
            color: #e08c68;
        }
        nav a.logout {
            color: #c24b2b;
            font-weight: bold;
        }
        section {
            padding: 100px 40px 60px;
            min-height: 100vh;
        }
        #accueil {
            background-color: #f3e9e3;
            text-align: center;
        }
       
      
        #feedbackForm form {
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            max-width: 600px;
            margin: auto;
        }
        textarea, select, input[type="number"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            background-color: #e08c68;
            border: none;
            padding: 10px 20px;
            color: white;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background-color: #d17a56;
        }
        footer {
            text-align: center;
            padding: 20px;
            background-color: #f3e9e3;
            color: #444;
        }
        ul {
            list-style-type: none;
        }

#accueil {
    background-image: url('images/bg.png'); /* adapte le chemin */
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
}

#accueil h1 {
    font-family: 'Playfair Display', serif;
    font-size: 3em;
    font-weight: 700;
    text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);
}

section#accueil {
    padding-top: 160px; /* laisse la place au header */
}

section{
    
     box-shadow: 0 2px 6px rgba(0, 0, 0, 0.05);
}

/* Section title */
.section-title {
    text-align: center;
    margin-bottom: 30px;
}
.section-title .subtitle {
    color: #c86b39;
    font-weight: 600;
    font-size: 0.9em;
    letter-spacing: 1px;
}
.section-title h2 {
    font-family: 'Playfair Display', serif;
    font-size: 2.5em;
}

/* Slider container */
.slider-wrapper {
    overflow-x: auto;
    overflow-y: hidden;
    white-space: nowrap;
    padding: 20px 0;
    scroll-snap-type: x mandatory;
}
.slider {
    display: flex;
    gap: 30px;
    padding: 10px 40px;
}

/* Slide */
.slide {
    flex: 0 0 auto;
    scroll-snap-align: center;
}

/* Product card inside slide */
.product-card {
     background-color: #fef8f4;
    width: 270px;
    border-radius: 16px;
    padding: 22px;
    text-align: center;
    box-shadow: 0 8px 20px rgba(0, 0, 0, 0.06);
    transition: transform 0.3s ease, box-shadow 0.3s ease;
    font-family: 'Poppins', sans-serif;
    overflow-wrap: break-word;
    word-wrap: break-word;
    word-break: break-word;
    white-space: normal;
}
.product-card:hover {
     transform: translateY(-5px);
    box-shadow: 0 12px 24px rgba(0, 0, 0, 0.08);
}
.product-card img {
  width: 100%;
    height: 160px;
    object-fit: cover;
    border-radius: 12px;
    margin-bottom: 18px;
}
.product-card h3 {
    font-family: 'Playfair Display', serif;
    font-size: 1.3em;
    font-weight: 700;
    color: #3c2f2f;
    margin-bottom: 6px;
}
.product-card .type {
    font-size: 0.9em;
    color: #7e5d51;
    margin-bottom: 10px;
}
.product-card .desc {
   font-size: 0.95em;
    color: #5a4a42;
    font-style: italic;
    margin-bottom: 12px;
}
.product-card .cat {
       font-size: 0.9em;
    color: #3e2f2f;
    font-weight: 500;
}

.feedback-container {
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
    gap: 40px;
    flex-wrap: wrap;
}

.feedback-form, .feedback-text {
    flex: 1;
    min-width: 300px;
}

.feedback-text {
    background-color: #fff4ef;
    padding: 30px;
    border-radius: 10px;
    font-family: 'Playfair Display', serif;
    color: #5c4033;
    box-shadow: 0 2px 10px rgba(0,0,0,0.05);
}

    
.feedback-card {
    background-color: #fff8f5;
    border-radius: 12px;
    padding: 22px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.04);
    width: 300px;
    flex: 1 1 300px;
    transition: transform 0.2s ease;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
}
.feedback-card:hover {
    transform: translateY(-4px);
}
.feedback-card p {
    font-size: 0.95em;
    color: #333;
    margin: 6px 0;
}
.feedback-card .icon {
    font-size: 1.2em;
    margin-right: 5px;
}

.feedback-actions {
    display: flex;
    justify-content: space-between;
    margin-top: 20px;
}
.btn-edit, .btn-danger {
    display: inline-flex;
    align-items: center;
    gap: 6px;
    font-size: 0.9em;
    padding: 8px 14px;
    border-radius: 6px;
    font-weight: 500;
    border: none;
    cursor: pointer;
    transition: background-color 0.3s;
}

.btn-edit {
    background-color: #ffe3a1;
    color: #5c4033;
}
.btn-edit:hover {
    background-color: #ffd277;
}

.btn-danger {
    background-color: #f9b3a3;
    color: #6a1b1b;
}
.btn-danger:hover {
    background-color: #f18270;
}

.feedback-card strong {
    color: #1d1d1d;
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

.filter-btn {
    background-color: #e08c68;
    color: white;
    padding: 8px 18px;
    margin: 0 6px 10px 6px;
    border: none;
    border-radius: 6px;
    cursor: pointer;
    font-weight: 500;
    transition: background-color 0.3s;
}

.filter-btn:hover {
    background-color: #d07550;
}

    </style>
</head>
<body>

<header>
    <div style="display: flex; align-items: center;">
        <img src="images/logo.png" alt="Feed4U Logo">

    </div>
    <nav>
        <a href="#accueil">Accueil</a>
        <a href="#produits">Produits</a>
        <a href="#feedbackForm">Feedback</a>
<a class="logout" href="DeconnexionController">
    <i class="fas fa-sign-out-alt"></i> Se déconnecter
</a>
    </nav>
</header>

<section id="accueil">
    <div>
        <h1>Bienvenue sur Feed4U</h1>
        <p>Exprimez librement votre avis et découvrez nos services !</p>
        <a href="#produits"><button>Explorer</button></a>
    </div>
</section>

<section id="produits">
    <div class="section-title">
        <p class="subtitle">CE QUE NOUS PROPOSONS</p>
        <h2>Nos Produits</h2>

        <!-- Filtres dynamiques -->
        <div style="margin-top: 20px;">
            <button class="filter-btn" onclick="filterCategory('all')">Tous</button>
            <button class="filter-btn" onclick="filterCategory('Soins du visage')">Soins du visage</button>
            <button class="filter-btn" onclick="filterCategory('Maquillage')">Maquillage</button>
            <button class="filter-btn" onclick="filterCategory('Soins capillaires')">Soins capillaires</button>
            <button class="filter-btn" onclick="filterCategory('Hygiène & Corps')">Hygiène & Corps</button>
        </div>
    </div>

    <div class="slider-wrapper">
        <div class="slider" id="productContainer">
            <c:forEach items="${produits}" var="p">
                <div class="slide product-card-wrapper" data-category="${p.categorie.nom}">
                    <div class="product-card">
                        <img src="images/p.png" alt="${p.nom}" />
                        <h3>${p.nom}</h3>
                        <p class="type">${p.type}</p>
                        <p class="desc"><em>${p.description}</em></p>
                        <p class="cat">Catégorie : <strong>${p.categorie.nom}</strong></p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>



<section id="feedbackForm">
    <div class="section-title">
    <span class="section-subtitle">EXPRIMEZ-VOUS</span>
    <h2>Laisser un Feedback</h2>
</div>
    
    <div class="feedback-container">
        
          <div class="feedback-text">
         <img src="images/feedback.png" alt="Illustration feedback" style="max-width: 260px; margin-bottom: 20px;" />

            <h3>Votre retour nous intéresse !</h3>
            <p>Vos commentaires nous aident à améliorer nos services. Merci pour votre contribution !</p>
        </div>
        <div class="feedback-form">
            
            <form action="FeedbackController" method="post">
                <label for="produit">Choisissez un produit :</label>
                <select name="produitId" required>
                    <c:forEach items="${produits}" var="p">
                        <option value="${p.idProduit}">${p.nom} (${p.type})</option>
                    </c:forEach>
                </select>

                <label for="note">Note (1 à 10) :</label>
                <input type="number" name="note" min="1" max="10" required />

                <label for="commentaire">Commentaire :</label>
                <textarea name="commentaire" rows="4" placeholder="Votre avis..." required></textarea>

                <div style="text-align: center; margin-top: 20px;">
    <button type="submit">Envoyer</button>
</div>
            </form>
        </div>

      
    </div>
</section>


<section id="myFeedbacks">
    <div class="section-title">
        <span class="section-subtitle">MES AVIS</span>
        <h2>Vos Feedbacks</h2>
    </div>
    <div style="display: flex; flex-wrap: wrap; gap: 20px;">
        <c:forEach items="${feedbacksClient}" var="fb">
            <div style="flex: 1 1 250px; background-color: #fff4ef; border-radius: 10px; padding: 20px; box-shadow: 0 2px 6px rgba(0,0,0,0.1);">
                <p><strong><i class="fa-solid fa-box"></i> Produit :</strong> ${fb.produit.nom}</p>
                <p><strong><i class="fa-solid fa-star"></i> Note :</strong> ${fb.note} / 10</p>
                <p><strong><i class="fa-solid fa-comment"></i> Commentaire :</strong> ${fb.commentaire}</p>
                <div style="margin-top: 10px; display: flex; gap: 10px;">
                    <form action="EditFeedbackController" method="get" style="display:inline;">
                        <input type="hidden" name="produitId" value="${fb.produit.idProduit}" />
<input type="hidden" name="produitId" value="${fb.produit.idProduit}" />
<button type="button"
    class="btn-action btn-edit"
    onclick="openEditModal('${fb.produit.idProduit}', '${fb.note}', '${fb.commentaire.replace("'", "\\'")}')">
    ✏ Modifier
</button>
                    </form>
                    <form action="DeleteFeedbackController" method="post" style="display:inline;" onsubmit="return confirm('Confirmer la suppression ?');">
                        <input type="hidden" name="produitId" value="${fb.produit.idProduit}" />
<form action="DeleteFeedbackController" method="post" style="display:inline;">
    <input type="hidden" name="produitId" value="${fb.produit.idProduit}">
    <button type="submit" class="btn-danger">🗑 Supprimer</button>
</form>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>
</section>



<footer>
    &copy; 2025 Feed4U — Merci de partager votre avis.
</footer>
<!-- Modal de modification -->
<div id="editModal" style="display:none; position:fixed; top:0; left:0; width:100%; height:100%; background:#00000066; backdrop-filter: blur(2px); justify-content:center; align-items:center; z-index:999;">
    <div style="background:#fff; padding:30px; border-radius:10px; width:90%; max-width:500px; position:relative;">
        <h3 style="margin-bottom:15px;">Modifier le Feedback</h3>
        <form id="editForm" action="EditFeedbackController" method="post">
            <input type="hidden" name="produitId" id="editProduitId"/>
            <label>Note (1 à 10)</label>
            <input type="number" name="note" id="editNote" min="1" max="10" required style="width:100%; margin-bottom:10px;" />

            <label>Commentaire</label>
            <textarea name="commentaire" id="editCommentaire" rows="4" style="width:100%;" required></textarea>

            <div style="text-align:right; margin-top:15px;">
                <button type="button" onclick="closeModal()" style="margin-right:10px; background:#ccc;">Annuler</button>
                <button type="submit" style="background:#e08c68; color:white;">Enregistrer</button>
            </div>
        </form>
    </div>
</div>
<script>
    function openEditModal(produitId, note, commentaire) {
        document.getElementById("editProduitId").value = produitId;
        document.getElementById("editNote").value = note;
        document.getElementById("editCommentaire").value = commentaire;
        document.getElementById("editModal").style.display = "flex";
    }

    function closeModal() {
        document.getElementById("editModal").style.display = "none";
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
    });
</script>

<script>
    function filterCategory(category) {
        const cards = document.querySelectorAll(".product-card-wrapper");
        cards.forEach(card => {
            const cat = card.getAttribute("data-category");
            if (category === "all" || cat === category) {
                card.style.display = "inline-block";
            } else {
                card.style.display = "none";
            }
        });
    }
</script>


</body>
</html>
