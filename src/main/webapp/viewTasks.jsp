<%@page import="java.util.*"%>
<%@page import="com.toDoListModel.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Tasks</title>
    
    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container my-5">
    <h2 class="text-center mb-4">Your Task List</h2>

    <%
        List<TasksEntity> tasks = (List<TasksEntity>) session.getAttribute("view");
        if (tasks != null && !tasks.isEmpty()) {
    %>

    <div class="table-responsive">
        <table class="table table-striped table-bordered text-center align-middle">
            <thead class="table-dark">
                <tr>
                    <th>Email</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Due Date <br><small>(YYYY-MM-DD)</small></th>
                    <th>Operation</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (TasksEntity entity : tasks) {
                        int id = entity.getId();
                        String email = entity.getUser().getEmail();
                        String title = entity.getTitle();
                        String description = entity.getDiscription();
                        Date date = entity.getDueDate();
                %>
                <tr>
                    <td><%= email %></td>
                    <td><%= title %></td>
                    <td><%= description %></td>
                    <td><%= date %></td>
                    <td>
                        <a href="updateTasks?id=<%= id %>" class="btn btn-sm btn-primary me-1">Update</a>
                        <a href="deleteTasks?id=<%= id %>" class="btn btn-sm btn-danger">Delete</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>

    <% } else { %>
        <div class="alert alert-warning text-center">
            No tasks found to display.
        </div>
    <% } %>
</div>

</body>
</html>
