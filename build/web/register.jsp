<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <title>Inscription - Feed4U</title>
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
  <style>
    body {
      margin: 0;
      font-family: 'Poppins', sans-serif;
      background-color: #fdf8f5;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
    .container {
      display: flex;
      max-width: 1000px;
      width: 90%;
      background-color: #fff;
      box-shadow: 0 6px 20px rgba(0,0,0,0.1);
      border-radius: 20px;
      overflow: hidden;
    }
    .left, .right {
      padding: 40px;
      flex: 1;
    }
    .left {
      display: flex;
      flex-direction: column;
      justify-content: center;
    }
    .left img.logo {
      width: 120px;
      margin: 0 auto 20px;
    }
    .left h2 {
      color: #e08c68;
      font-weight: 700;
      margin-bottom: 20px;
      text-align: center;
    }
    .left input {
      width: 100%;
      padding: 12px;
      border: 1px solid #ddd;
      border-radius: 8px;
      margin-bottom: 15px;
      font-size: 1em;
      background-color: #f0f4ff;
    }
    .left button {
      display: block;
      background-color: #e08c68;
      color: white;
      padding: 10px 30px;
      font-size: 0.95em;
      border: none;
      border-radius: 6px;
      font-weight: 500;
      cursor: pointer;
      transition: background-color 0.3s;
      margin: 10px auto 0;
    }
    .left button:hover {
      background-color: #d07550;
    }
    .left .login-link {
      margin-top: 10px;
      text-align: center;
      font-size: 0.95em;
    }
    .left .login-link a {
      color: #e08c68;
      text-decoration: none;
      font-weight: 500;
    }
    .right {
      background-color: #fff1e9;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      text-align: center;
    }
    .right h1 {
      color: #333;
      font-size: 2em;
      margin-bottom: 20px;
    }
    .right p {
      color: #555;
      font-size: 1em;
      max-width: 300px;
    }
    .right img {
      max-width: 200px;
      margin-top: 20px;
    }
    @media (max-width: 768px) {
      .container {
        flex-direction: column;
        border-radius: 0;
        height: 100vh;
      }
      .right {
        order: -1;
      }
    }
  </style>
</head>
<body>
  <div class="container">
      <div class="right">
      <h1>Bienvenue sur Feed4U</h1>
      <p>Rejoignez-nous pour accéder à un espace client personnalisé et enrichi par les retours utilisateurs.</p>
      <img src="images/feedback.png" alt="Illustration">
    </div>
    <div class="left">
      <img src="images/logo.png" alt="Feed4U Logo" class="logo">
      <h2>Créer un compte</h2>
      <form action="RegisterController" method="post">
        <input type="text" name="nom" placeholder="Nom complet" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="password" name="password" placeholder="Mot de passe" required>
        <button type="submit">S'inscrire</button>
      </form>
      <div class="login-link">
        Déjà inscrit ? <a href="login.jsp">Se connecter</a>
      </div>
    </div>
    
  </div>
</body>
</html>
