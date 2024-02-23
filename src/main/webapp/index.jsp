<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">

<%@ page import="com.example.demoe_2jee.BrandDao" %>
<%@ page import="com.example.demoe_2jee.Brand" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demoe_2jee.BrandDaoimp" %>
<%@ page import="static java.sql.DriverManager.println" %>
<%  BrandDao brandDao=new BrandDaoimp();%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.tailwindcss.com" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Material+Icons|Material+Icons+Outlined|Material+Icons+Two+Tone|Material+Icons+Round|Material+Icons+Sharp" rel="stylesheet">
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <title>Brand</title>
</head>

<body class="h-screen overflow-hidden flex items-center justify-center" style="background: #edf2f7;">
<%
//    BrandDao brandDao = new BrandDaoimp();
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("email")&&cookie.getValue().equals("password")) {
                println("Welcome back " );
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
        }
    }
    List<Brand> brands = brandDao.getAllBrand();
    for (Brand brand : brands) {
        System.out.println(brand);
    }%>
<%!
    BrandDao brandDao = new BrandDaoimp();
    // Méthode pour supprimer une marque
    public void deleteBrand(int id) {
        brandDao.deleteBrend(id);
        System.out.println("Marque supprimée avec l'ID : " + id);
    }

    // Méthode pour mettre à jour une marque
    public void updateBrand(HttpServletRequest request) {
        System.out.println("la methode updateBrand");
        int id = Integer.parseInt(request.getParameter("id"));
        Brand brandToUpdate = new Brand();
        brandToUpdate.setImage_url(request.getParameter("image_url"));
        brandToUpdate.setBrand(request.getParameter("brand"));
        brandToUpdate.setEmail(request.getParameter("email"));
        brandToUpdate.setCategory(request.getParameter("category"));
        brandToUpdate.setPrice(Double.parseDouble(request.getParameter("price")));
        brandToUpdate.setStatus(request.getParameter("status"));
        brandDao.updateBrand(brandToUpdate, id);
    }

    // Méthode pour ajouter une nouvelle marque
    public void addBrand(HttpServletRequest request) {
        System.out.println("la methode addBrand");
        Brand brandToAdd = new Brand();
        brandToAdd.setImage_url(request.getParameter("image_url"));
        brandToAdd.setBrand(request.getParameter("brand"));
        brandToAdd.setEmail(request.getParameter("email"));
        brandToAdd.setCategory(request.getParameter("category"));
        brandToAdd.setPrice(Double.parseDouble(request.getParameter("price")));
        brandToAdd.setStatus(request.getParameter("status"));
        brandDao.add_Brand(brandToAdd);
    }

%>
<%

    String action = request.getParameter("action");
    if (action != null) {
    switch (action) {
        case "add":
            addBrand(request);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            break;
        case "update":
            updateBrand(request);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            break;
        case "delete":
//            int id = Integer.parseInt(request.getParameter("id"));
            String idParam = request.getParameter("id");
            if (idParam != null && !idParam.isEmpty()) {
                int id = Integer.parseInt(idParam);
                deleteBrand(id);
            }
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            break;
        default:
            break;

    }
    }
%>
<div  class="flex items-center justify-center min-h-screen bg-gray-900 w-full">
    <div class="col-span-12">
        <div class="overflow-auto lg:overflow-visible ">
            <table class="table text-gray-400 border-separate space-y-6 text-sm">

                <thead class="bg-gray-800 text-gray-500">
                <tr class="w-full">
                    <!-- Utilisez col-span-full pour que le bouton occupe toutes les colonnes -->

                    <button type="button" id="add-btn" class="rounded-lg h-14 hover:bg-green-700 w-full flex items-center justify-center bg-gray-800">
                        <a href="add.jsp" ><span class="material-symbols-outlined px-8 md:px-16"><img src="./add_shopping_cart.png"></span></a>
                    </button>


                <tr>
                    <th class="p-3">Brand</th>
                    <th class="p-3 text-left">Category</th>
                    <th class="p-3 text-left">Price</th>
                    <th class="p-3 text-left">Status</th>
                    <th class="p-3 text-left">Action</th>
                </tr>
                </thead>
                <tbody id="read">
                <% for (Brand brand : brands) { %>
                <tr class="bg-gray-800">
                    <td class="p-3">
                        <div class="flex align-items-center">
                            <img class="rounded-full h-12 w-12  object-cover" src="<%= brand.getImage_url()%>" alt="unsplash image">
                            <div class="ml-3">
                                <div class=""><%= brand.getBrand()%></div>
                                <div class="text-gray-500"><%= brand.getEmail()%></div>
                            </div>
                        </div>
                    </td>
                    <td class="p-3">
                        <%= brand.getCategory()%>
                    </td>
                    <td class="p-3 font-bold">
                        <%= brand.getPrice() %>$
                    </td>
                    <td class="p-3">
                        <span class="bg-green-400 text-gray-50 rounded-md px-2">available</span>
                    </td>
                    <td class="p-3 ">

<%--                        <a href="#" class="text-gray-400 hover:text-gray-100 mr-2">--%>
<%--                            <i class="material-icons-outlined text-base">check</i>--%>
<%--                        </a>--%>
<%--                        <a href="#" class="text-gray-400 hover:text-gray-100 mr-2">--%>
<%--                            <i class="material-icons-outlined text-base">visibility</i>--%>
<%--                        </a>--%>
                        <a href="edit.jsp" class="text-gray-400 hover:text-gray-100  mx-2">
                            <i class="material-icons-outlined text-base">edit</i>
                        </a>
<%--                        <a href="#" class="text-gray-400 hover:text-gray-100  ml-2">--%>
<%--                            <i class="material-icons-round text-base">delete_outline</i>--%>
<%--                        </a>--%>
                        <form id="deleteForm<%=brand.getId()%>" action="" method="post">
                            <input type="hidden" name="id" value="<%=brand.getId()%>">
                            <button type="submit" name="action" value="delete" class="text-gray-400 hover:text-gray-100 ml-2">
                                <i class="material-icons-round text-base">delete_outline</i>
                            </button>
                        </form>

                    </td>
                </tr>
                <% } %>
<%--                <tr class="bg-gray-800">--%>
<%--                    <td class="p-3">--%>
<%--                        <div class="flex align-items-center">--%>
<%--                            <img class="rounded-full h-12 w-12   object-cover" src="https://images.unsplash.com/photo-1423784346385-c1d4dac9893a?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80" alt="unsplash image">--%>
<%--                            <div class="ml-3">--%>
<%--                                <div class="">Realme</div>--%>
<%--                                <div class="text-gray-500">mail@rgmail.com</div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </td>--%>
<%--                    <td class="p-3">--%>
<%--                        Technology--%>
<%--                    </td>--%>
<%--                    <td class="p-3 font-bold">--%>
<%--                        200.00$--%>
<%--                    </td>--%>
<%--                    <td class="p-3">--%>
<%--                        <span class="bg-red-400 text-gray-50 rounded-md px-2">no stock</span>--%>
<%--                    </td>--%>
<%--                    <td class="p-3">--%>

<%--                        <a href="#" class="text-gray-400 hover:text-gray-100 mr-2">--%>
<%--                            <i class="material-icons-outlined text-base">check</i>--%>
<%--                        </a>--%>

<%--                        <a href="#" class="text-gray-400 hover:text-gray-100  mr-2">--%>
<%--                            <i class="material-icons-outlined text-base">visibility</i>--%>
<%--                        </a>--%>
<%--                        <a href="#" class="text-gray-400 hover:text-gray-100 mx-2">--%>
<%--                            <i class="material-icons-outlined text-base">edit</i>--%>
<%--                        </a>--%>
<%--                        <a href="#" class="text-gray-400 hover:text-gray-100 ml-2">--%>
<%--                            <i class="material-icons-round text-base">delete_outline</i>--%>
<%--                        </a>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--                <tr class="bg-gray-800">--%>
<%--                    <td class="p-3">--%>
<%--                        <div class="flex align-items-center">--%>
<%--                            <img class="rounded-full h-12 w-12   object-cover" src="https://images.unsplash.com/photo-1600856209923-34372e319a5d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2135&q=80" alt="unsplash image">--%>
<%--                            <div class="ml-3">--%>
<%--                                <div class="">Samsung</div>--%>
<%--                                <div class="text-gray-500">mail@rgmail.com</div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </td>--%>
<%--                    <td class="p-3">--%>
<%--                        Technology--%>
<%--                    </td>--%>
<%--                    <td class="p-3 font-bold">--%>
<%--                        200.00$--%>
<%--                    </td>--%>
<%--                    <td class="p-3">--%>
<%--                        <span class="bg-yellow-400 text-gray-50  rounded-md px-2">start sale</span>--%>
<%--                    </td>--%>
<%--                    <td class="p-3">--%>
<%--                        <a href="#" class="text-gray-400 hover:text-gray-100 mr-2">--%>
<%--                            <i class="material-icons-outlined text-base">check</i>--%>
<%--                        </a>--%>
<%--                        <a href="#" class="text-gray-400 hover:text-gray-100 mr-2">--%>
<%--                            <i class="material-icons-outlined text-base">visibility</i>--%>
<%--                        </a>--%>
<%--                        <a href="#" class="text-gray-400 hover:text-gray-100 mx-2">--%>
<%--                            <i class="material-icons-outlined text-base">edit</i>--%>
<%--                        </a>--%>
<%--                        <a href="#" class="text-gray-400 hover:text-gray-100 ml-2">--%>
<%--                            <i class="material-icons-round text-base">delete_outline</i>--%>
<%--                        </a>--%>
<%--                    </td>--%>
<%--                </tr>--%>
                </tbody>
            </table>
        </div>
    </div>
</div>
<style>
    .body{
        margin: 0px;
        padding: 0px;
    }
    .table {
        border-spacing: 0 15px;
    }

    i {
        font-size: 1rem !important;
    }

    .table tr {
        border-radius: 20px;
    }

    tr td:nth-child(n+5),
    tr th:nth-child(n+5) {
        border-radius: 0 .625rem .625rem 0;
    }

    tr td:nth-child(1),
    tr th:nth-child(1) {
        border-radius: .625rem 0 0 .625rem;
    }

    /* .table {
            width: 100%; /* Ajoutez ceci pour que la table prenne toute la largeur disponible */
    /* }  */

    .table th, .table td {
        text-align: left; /* Alignez le texte à gauche dans les cellules de la table */
        padding: 1rem; /* Ajoutez un padding pour l'espace à l'intérieur des cellules */
    }

    /* Ajoutez ce style pour aligner le div avec la hauteur de la ligne de la table */
    .table .button-row {
        display: flex;
        align-items: center;
        height: 100%; /* Ajustez la hauteur selon vos besoins */
    }

    .table .button-row button {
        margin: 0 auto; /* Centrez le bouton horizontalement dans le div */
    }
</style>
</body>
</html>
