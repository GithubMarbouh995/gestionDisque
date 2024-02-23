//package com.example.demoe_2jee;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@WebServlet(name = "addServlet", value ="/add")
//
//public class AddServlet extends HttpServlet {
//
//    private String message;
//    @Override
//    public void init() {
//
//    }
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<meta charset=\"utf-8\">\n" +
//                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
//                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
//                "    <link href=\"https://fonts.googleapis.com/css?family=Material+Icons|Material+Icons+Outlined|Material+Icons+Two+Tone|Material+Icons+Round|Material+Icons+Sharp\" rel=\"stylesheet\">\n" +
//                "    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200\" />\n"+
//                "    <script src='https://cdn.tailwindcss.com?plugins=forms,typography,aspect-ratio,line-clamp'></script>");
//        out.println("</head>");
//        out.println("<body class=\"bg-gray-900 \">");
//        out.println("<div class=\"flex items-center justify-center h-screen m-62\">");
//        out.println("<form class=\"max-w-md mx-auto \" action='/demo/delete' method='post'>");
//
//        out.println("<input type=\"hidden\" name=\"action\" value=\"add\" />\n");
//
//        out.println("        <div class=\"relative z-0 w-full mb-5 group\">");
//        out.println("            <input type=\"text\" name=\"brand\" id=\"floating_brand\" class=\"block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer\" placeholder=\" \" required />");
//        out.println("            <label for=\"floating_first_name\" class=\"peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6\">Brand</label>");
//        out.println("        </div>");
//
//        out.println("        <div class=\"relative z-0 w-full mb-5 group\">");
//        out.println("            <input type=\"text\" name=\"category\" id=\"floating_brand\" class=\"block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer\" placeholder=\" \" required />");
//        out.println("            <label for=\"floating_first_name\" class=\"peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6\">Category</label>");
//        out.println("        </div>");
//
//        out.println("        <div class=\"relative z-0 w-full mb-5 group\">");
//        out.println("            <input type=\"text\" name=\"price\" id=\"floating_brand\" class=\"block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer\" placeholder=\" \" required />");
//        out.println("            <label for=\"floating_first_name\" class=\"peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6\">Price</label>");
//        out.println("        </div>");
//
//        out.println("        <div class=\"relative z-0 w-full mb-5 group\">");
//        out.println("            <input type=\"text\" name=\"status\" id=\"floating_brand\" class=\"block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer\" placeholder=\" \" required />");
//        out.println("            <label for=\"floating_first_name\" class=\"peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6\">Status</label>");
//        out.println("        </div>");
//
//
//        out.println("    <div class=\"relative z-0 w-full mb-5 group\">");
//        out.println("        <input type=\"email\" name=\"email\" id=\"floating_email\" class=\"block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer\" placeholder=\" \" required />");
//        out.println("        <label for=\"floating_email\" class=\"peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 rtl:peer-focus:left-auto peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6\">Email address</label>");
//        out.println("    </div>");
//
//        out.println("        <div class=\"relative z-0 w-full mb-5 group\">");
//        out.println("            <input type=\"text\" name=\"image_url\" id=\"floating_last_name\" class=\"block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer\" placeholder=\" \" required />");
//        out.println("            <label for=\"floating_last_name\" class=\"peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6\">Lien d'image</label>");
//        out.println("    </div>");
//
//        out.println("    <button type=\"submit\" class=\"text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800\">Submit</button>");
//        out.println("</form>");
//        out.println("</div>");
//
//        out.println("</body></html>");
//    }
//
//
//    @Override
//
//    public void destroy() {
//    }
//
//
//}
