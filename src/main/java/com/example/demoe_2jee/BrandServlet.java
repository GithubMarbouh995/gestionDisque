//package com.example.demoe_2jee;
//
//import java.io.*;
//import java.nio.file.FileStore;
//import java.util.List;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
//
//@WebServlet(name = "helloServlet", value = {"","/delete"})
//public class BrandServlet extends HttpServlet {
//    private String message;
//    private int indice;
//
//    public void init() {
//        message = "Hello World!";
//    }
//
//    BrandDao brandDao=new BrandDaoimp();
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        List<Brand> brands=brandDao.getAllBrand();
//        response.setContentType("text/html");
//        // Hello
//        PrintWriter out = response.getWriter();
//
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<meta charset=\"utf-8\">\n" +
//                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
//                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
//                    "    <link href=\"https://cdn.tailwindcss.com\" rel=\"stylesheet\">\n" +
//                    "    <link href=\"https://fonts.googleapis.com/css?family=Material+Icons|Material+Icons+Outlined|Material+Icons+Two+Tone|Material+Icons+Round|Material+Icons+Sharp\" rel=\"stylesheet\">\n" +
//                    "    <link href=\"https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css\" rel=\"stylesheet\">\n" +
//                    "    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200\" />");
//            out.println("</head>");
//
//            out.println("<body>");
//            out.println("<div class=\"flex items-center justify-center min-h-screen bg-gray-900 w-full\">\n" +
//                "    <div class=\"col-span-12\">\n" +
//                "        <div class=\"overflow-auto lg:overflow-visible \">\n" +
//                "            <table class=\"table text-gray-400 border-separate space-y-6 text-sm\">\n" +
//                "\n" +
//                "                <thead class=\"bg-gray-800 text-gray-500\">\n" +
//                "                    <tr class=\"w-full\">\n" +
//                "                        <!-- Utilisez col-span-full pour que le bouton occupe toutes les colonnes -->\n" +
//                "\n" +
//                "                        <button type=\"button\" id=\"add-btn\" class=\"rounded-lg h-14 hover:bg-green-700 w-full flex items-center justify-center bg-gray-800\">\n" +
//                "                            <a href='/demo/add'><span class=\"material-symbols-outlined px-8 md:px-16\"><img src=\"./add_shopping_cart.png\"></span></a>\n" +
//                "                        </button>\n" +
//                "\n" +
//                "\n" +
//                "                    </tr>\n" +
//                "\n" +
//                "                    <tr>\n" +
//                "                        <th class=\"p-3\">Brand</th>\n" +
//                "                        <th class=\"p-3 text-left\">Category</th>\n" +
//                "                        <th class=\"p-3 text-left\">Price</th>\n" +
//                "                        <th class=\"p-3 text-left\">Status</th>\n" +
//                "                        <th class=\"p-3 text-left\">Action</th>\n" +
//                "                    </tr>\n" +
//                "                </thead>\n" +
//                "                <tbody id=\"read\">");
////        HttpSession session = request.getSession();
////        Integer indice = (Integer) session.getAttribute("indice");
////
////        if (indice == null) {
////            indice = 0;
////            request.setAttribute("indice", indice);
////        }
//        for (Brand brand : brands) {
//            out.println("<tr class=\"bg-gray-800\">");
//
//
//            out.println("<td class=\"p-3\">");
//            out.println("<div class=\"flex align-items-center\">");
//            out.println("<img class=\"rounded-full h-12 w-12  object-cover\" src=\"" + brand.getImage_url() + "\" alt=\"brand image\">");
//            out.println("<div class=\"ml-3\">");
//            out.println("<div class=\"\">" + brand.getBrand() + "</div>");
//            out.println("<div class=\"text-gray-500\">" + brand.getEmail() + "</div>");
//            out.println("</div>");
//            out.println("</div>");
//            out.println("</td>");
//
//
//            out.println("<td class=\"p-3\">");
//            out.println(brand.getCategory());
//            out.println("</td>");
//
//
//            out.println("<td class=\"p-3 font-bold\">");
//            out.println(brand.getPrice() + "$");
//            out.println("</td>");
//
//
//            out.println("<td class=\"p-3\">");
//            out.println("<span class=\"bg-green-400 text-gray-50 rounded-md px-2\">" + brand.getStatus() + "</span>");
//            out.println("</td>");
//
//
//            out.println("<td class=\"p-3 \">");
//
////            out.println("<a href=\"#\" class=\"text-gray-400 hover:text-gray-100 mr-2\">");
////            out.println("<i class=\"material-icons-outlined text-base\">check</i>");
////            out.println("</a>");
////
////            out.println("<a href=\"#\" class=\"text-gray-400 hover:text-gray-100 mr-2\">");
////            out.println("<i class=\"material-icons-outlined text-base\">visibility</i>");
////            out.println("</a>");
//
//            out.println("<a href=\"/demo/edit\" class=\"text-gray-400 hover:text-gray-100 mx-2\">");
//            out.println("<i class=\"material-icons-outlined text-base\">edit</i>");
//            out.println("</a>");
//
////            out.println("<form id='deleteForm" + indice + "' method='post'>");
////            out.println("<a href='#' class='text-gray-400 hover:text-gray-100 ml-2' onclick='submitDeleteForm(" + indice + ")'>");
////            out.println("<i class='material-icons-round text-base'>delete_outline</i>");
////            out.println("</a>");
////            out.println("</form>");
////            out.println("<form id='deleteForm" + brand.getId() + "' method='post'>");
////            out.println("  <input type='hidden' name='id' value='" + brand.getId() + "'>");
////            out.println("  <a href='#' class='text-gray-400 hover:text-gray-100 ml-2' onclick='submitDeleteForm(" + brand.getId() + ")'>");
////            out.println("    <i class='material-icons-round text-base'>delete_outline</i>");
////            out.println("  </a>");
////            out.println("</form>");
//
//            out.println("<form id='deleteForm" + brand.getId() + "' method='post'>");
//            out.println("  <input type='hidden' name='id' value='" + brand.getId() + "'>");
//            out.println("  <button type='submit' name='action' value='delete' class='text-gray-400 hover:text-gray-100 ml-2'>");
//            out.println("    <i class='material-icons-round text-base'>delete_outline</i>");
//            out.println("  </button>");
//            out.println("</form>");
//
//
//            out.println("</td>");
//
//            out.println("</tr>");
//
////            session.setAttribute("indice", indice + 1);
//         }
//
//
//           out.println("                </tbody>\n" +
//                "            </table>\n" +
//                "        </div>\n" +
//                "    </div>\n" +
//                "</div>");
//
//
//             out.println("</body>");
//             out.println("<style>\n" +
//                    "    .body{\n" +
//                    "        margin: 0px;\n" +
//                    "        padding: 0px;\n" +
//                    "    }\n" +
//                    "    .table {\n" +
//                    "        border-spacing: 0 15px;\n" +
//                    "    }\n" +
//                    "\n" +
//                    "    i {\n" +
//                    "        font-size: 1rem !important;\n" +
//                    "    }\n" +
//                    "\n" +
//                    "    .table tr {\n" +
//                    "        border-radius: 20px;\n" +
//                    "    }\n" +
//                    "\n" +
//                    "    tr td:nth-child(n+5),\n" +
//                    "    tr th:nth-child(n+5) {\n" +
//                    "        border-radius: 0 .625rem .625rem 0;\n" +
//                    "    }\n" +
//                    "\n" +
//                    "    tr td:nth-child(1),\n" +
//                    "    tr th:nth-child(1) {\n" +
//                    "        border-radius: .625rem 0 0 .625rem;\n" +
//                    "    }\n" +
//                    "\n" +
//                    "    /* .table {\n" +
//                    "            width: 100%; /* Ajoutez ceci pour que la table prenne toute la largeur disponible */\n" +
//                    "    /* }  */\n" +
//                    "\n" +
//                    "    .table th, .table td {\n" +
//                    "        text-align: left; /* Alignez le texte à gauche dans les cellules de la table */\n" +
//                    "        padding: 1rem; /* Ajoutez un padding pour l'espace à l'intérieur des cellules */\n" +
//                    "    }\n" +
//                    "\n" +
//                    "    /* Ajoutez ce style pour aligner le div avec la hauteur de la ligne de la table */\n" +
//                    "    .table .button-row {\n" +
//                    "        display: flex;\n" +
//                    "        align-items: center;\n" +
//                    "        height: 100%; /* Ajustez la hauteur selon vos besoins */\n" +
//                    "    }\n" +
//                    "\n" +
//                    "    .table .button-row button {\n" +
//                    "        margin: 0 auto; /* Centrez le bouton horizontalement dans le div */\n" +
//                    "    }\n" +
//                    "</style>");
//
////        out.println("<script>");
////        out.println("function submitDeleteForm(indice) {");
////        out.println("    document.getElementById('deleteForm' + indice).action = '/demo/delete?action=delete&index=' + indice;");
////        out.println("    document.getElementById('deleteForm' + indice).submit();");
////        out.println("}");
////        out.println("</script>");
//        out.println("</html>");
//
//
//    }
//        @Override
//        protected void doPost(HttpServletRequest request, HttpServletResponse response)
//
//            throws IOException {
//            List<Brand> brands=brandDao.getAllBrand();
//            String action = request.getParameter("action");
//
//        switch (action) {
//            case "add":
//                addBrand(request);
//                response.sendRedirect(request.getContextPath() + "/delete");
//                break;
//            case "update":
//                updateBrand(request);
//                response.sendRedirect(request.getContextPath() + "/delete");
//                break;
//            case "delete":
////                deleteBrand(request);
////                response.sendRedirect(request.getContextPath() + "/delete");
//                int id = Integer.parseInt(request.getParameter("id"));
//                deleteBrand(id);
//                response.sendRedirect(request.getContextPath() + "/delete");
//                break;
//            default:
//                break;
//        }
//
//    }
////    public void deleteBrand(HttpServletRequest request){
//////        HttpSession session = request.getSession();
//////        Integer indice = (Integer) session.getAttribute("indice");
//////
//////        if (indice != null) {
//////            int indiceValue = indice.intValue();
//////            brandDao.deleteBrend(indiceValue);
//////            System.out.println("Brand supprimée avec l'indice : " + indiceValue);
//////        } else {
//////            System.out.println("La valeur de indice dans la session est null. Impossible de supprimer la Brand.");
//////        }
////
////
////    }
//public void deleteBrand(int id) {
//    brandDao.deleteBrend(id);
//    System.out.println("Marque supprimée avec l'ID : " + id);
//}
//
//    public void updateBrand(HttpServletRequest request){
//        System.out.println("la methode updateBrand");
//        int id = Integer.parseInt(request.getParameter("id"));
//        Brand brandToUpdate =new Brand();
//        brandToUpdate.setImage_url(request.getParameter("image_url"));
//        brandToUpdate.setBrand(request.getParameter("brand"));
//        brandToUpdate.setEmail(request.getParameter("email"));
//        brandToUpdate.setCategory(request.getParameter("category"));
//        brandToUpdate.setPrice(Double.parseDouble(request.getParameter("price")));
//        brandToUpdate.setStatus(request.getParameter("status"));
//        brandDao.updateBrand(brandToUpdate,id);
//    }
//    public void addBrand(HttpServletRequest request){
//        System.out.println("la methode addBrand");
//        Brand brandToAdd =new Brand();
//        brandToAdd.setImage_url(request.getParameter("image_url"));
//        brandToAdd.setBrand(request.getParameter("brand"));
//        brandToAdd.setEmail(request.getParameter("email"));
//        brandToAdd.setCategory(request.getParameter("category"));
//        brandToAdd.setPrice(Double.parseDouble(request.getParameter("price")));
//        brandToAdd.setStatus(request.getParameter("status"));
//        brandDao.add_Brand(brandToAdd);
//
//    }
//    public void destroy() {
//    }
//}