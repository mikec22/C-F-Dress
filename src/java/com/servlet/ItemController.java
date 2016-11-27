/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.Item;
import com.db.ItemDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author shukyan
 */
@WebServlet(name = "itemController", urlPatterns = {"/item"})
public class ItemController extends HttpServlet {

    private ItemDB itemDB;

    @Override
    public void init() {
        String dburl = this.getServletContext().getInitParameter("dbUrl");
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        itemDB = new ItemDB(dburl, dbUser, dbPassword);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        action = action == null ? "" : action;
        if (action.equalsIgnoreCase("manageList")) {
            showManagerItemList(request, response);
        } else if (action.equals("manageItemDetail")) {
            doManageItemDatail(request, response);
        } else if (action.equals("getItem")) {
            showItem(request, response);
        } else if (action.equals("getItemList")) {
            showItemList(request, response);
        } else if (action.equalsIgnoreCase("changeOrder")) {
            changeOrder(request, response);
        } else {
            PrintWriter out = response.getWriter();
            out.println("No such action!!!");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);;
        }

    }

    private void showItem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id;
        String title;
        try {
            id = Integer.parseInt(request.getParameter("id"));
            Item item = itemDB.getItem(id);
            if (item != null) {
                if (item.getCategory().equals("gifts")) {
                    HttpSession session = request.getSession();
                    if (session.getAttribute("clientInfo") == null) {
                        throw new ServletException();
                    }
                }
                title = item.getName();
                request.setAttribute("item", item);
                request.setAttribute("title", title);
                getServletContext().getRequestDispatcher("/itemDetails.jsp").forward(request, response);
            } else {
                throw new ServletException();
            }
        } catch (IOException | NumberFormatException | ServletException e) {
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    private void doManageItemDatail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id;
        String title;
        try {
            id = Integer.parseInt(request.getParameter("id"));
            Item item = itemDB.getItem(id);
            if (item != null) {
                title = item.getName();
                request.setAttribute("item", item);
                request.setAttribute("title", title);
                getServletContext().getRequestDispatcher("/manageItemDetail.jsp").forward(request, response);
            } else {
                throw new ServletException();
            }
        } catch (IOException | NumberFormatException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void showItemList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Vector<Item> itemList;
        String keyword = request.getParameter("keyword");
        String category = request.getParameter("category");
        String title;
        keyword = keyword == null ? "" : keyword;
        try {
            if (category == null || category.equalsIgnoreCase("")) {
                if (session.getAttribute("clientInfo") != null) {
                    itemList = itemDB.queryItemByKeyword(keyword);
                } else {
                    itemList = itemDB.querySellItemByKeyword(keyword);
                }
                title = "C&F Dress ";
            } else {
                if (category.equalsIgnoreCase("gifts")) {
                    if (session.getAttribute("clientInfo") != null) {
                        itemList = itemDB.queryItemByCategoryKeyword(keyword, category);
                        title = "C&F Dress - " + category;
                    } else {
                        itemList = itemDB.querySellItemByKeyword(keyword);
                        title = "C&F Dress ";
                    }
                } else {
                    itemList = itemDB.queryItemByCategoryKeyword(keyword, category);
                    title = "C&F Dress - " + category;
                }

            }
            category = category == null ? "" : category;
            if (!keyword.equalsIgnoreCase("")) {
                request.setAttribute("search", "Search by \"" + keyword + "\" total " + itemList.size() + " match item");
            }
            if (!category.equalsIgnoreCase("")) {
                request.setAttribute("msg", "Category : " + category);
            }
            request.setAttribute("itemList", itemList);
            request.setAttribute("title", title);
            request.setAttribute("keyword", keyword);
            request.setAttribute("category", category);
            getServletContext().getRequestDispatcher("/item.jsp").forward(request, response);
        } catch (IOException | NumberFormatException | ServletException e) {
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    private void showManagerItemList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Vector<Item> itemList;
        String keyword = request.getParameter("keyword");
        String category = request.getParameter("category");
        String title;
        keyword = keyword == null ? "" : keyword;
        try {
            if (category == null) {
                itemList = itemDB.queryItemByKeyword(keyword);
                title = "C&F Dress ";
            } else {
                itemList = itemDB.queryItemByCategoryKeyword(keyword, category);
                title = "C&F Dress - " + category;
            }
            request.setAttribute("itemList", itemList);
            request.setAttribute("title", title);
            getServletContext().getRequestDispatcher("/managerItem.jsp").forward(request, response);
        } catch (IOException | NumberFormatException | ServletException e) {
            getServletContext().getRequestDispatcher("/ManagerLogin").forward(request, response);
        }
    }

    private void changeOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Vector<Item> itemList;
        String keyword = request.getParameter("keyword");
        String category = request.getParameter("category");
        String sortby = request.getParameter("sortby");
        String orderby = request.getParameter("orderby");
        String title;
        sortby = sortby == null ? "item_id" : sortby;
        orderby = orderby == null ? "asc" : orderby;
        keyword = keyword == null ? "" : keyword;
        String itemIDSelected = sortby.equals("item_id") ? "selected" : "";
        String nameSelected = sortby.equals("name") ? "selected" : "";
        String priceSelected = sortby.equals("price") ? "selected" : "";
        String categorySelected = sortby.equals("category") ? "selected" : "";
        String designerSelected = sortby.equals("designer") ? "selected" : "";
        String ascSelected = orderby.equals("ASC") ? "selected" : "";
        String descSelected = orderby.equals("DESC") ? "selected" : "";
        try {
            if (category == null || category.equalsIgnoreCase("")) {
                if (session.getAttribute("clientInfo") != null) {
                    itemList = itemDB.querychangeOrderItemByKeyword(keyword, sortby, orderby);
                } else {
                    itemList = itemDB.querychangeOrderSellItemByKeyword(keyword, sortby, orderby);
                }
                title = "C&F Dress ";
            } else {
                if (category.equalsIgnoreCase("gifts")) {
                    if (session.getAttribute("clientInfo") != null) {
                        itemList = itemDB.querychangeOrderItemByKeyword(keyword, category, sortby, orderby);
                        title = "C&F Dress - " + category;
                    } else {
                        itemList = itemDB.querychangeOrderSellItemByKeyword(keyword, sortby, orderby);
                        title = "C&F Dress ";
                    }
                } else {
                    itemList = itemDB.querychangeOrderItemByKeyword(keyword, category, sortby, orderby);
                    title = "C&F Dress - " + category;
                }

            }
            category = category == null ? "" : category;
            if (!keyword.equalsIgnoreCase("")) {
                request.setAttribute("search", "Search by \"" + keyword + "\" total " + itemList.size() + " match item");
            }
            if (!category.equalsIgnoreCase("")) {
                request.setAttribute("msg", "Category : " + category);
            }
            request.setAttribute("itemList", itemList);
            request.setAttribute("title", title);
            request.setAttribute("sortby", sortby);
            request.setAttribute("orderby", orderby);
            request.setAttribute("keyword", keyword);
            request.setAttribute("category", category);
            request.setAttribute("itemIDSelected", itemIDSelected);
            request.setAttribute("nameSelected", nameSelected);
            request.setAttribute("priceSelected", priceSelected);
            request.setAttribute("categorySelected", categorySelected);
            request.setAttribute("designerSelected", designerSelected);
            request.setAttribute("ascSelected", ascSelected);
            request.setAttribute("descSelected", descSelected);
            getServletContext().getRequestDispatcher("/item.jsp").forward(request, response);
        } catch (IOException | NumberFormatException | ServletException e) {
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
