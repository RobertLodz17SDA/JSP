<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="pl.sdacademy.model.Gallery" %>
<%@ page import="pl.sdacademy.model.enums.GalleryDisplayType" %>
<%@ page import="pl.sdacademy.model.Image" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Gallery</title>
</head>
<body>
<h1>Gallery</h1>

<%
    List<String> imagesURLs = (ArrayList<String>) request.getAttribute("urls");
    GalleryDisplayType displayType = (GalleryDisplayType) request.getAttribute("display_type");

    Gallery gallery = new Gallery("Modified gallery");
    for (String url : imagesURLs) {
        gallery.addImage(url, "Some image");
    }
%>
<h4>Name: <%= gallery.getName() %>
</h4>
<h4>Created: <%= gallery.getCreated() %>
</h4>
<br>
<jsp:include page="menu.jsp" />

<table border=1>
    <% if (displayType.equals(GalleryDisplayType.ONE_COLUMN)) {
        for (Image image : gallery.getImages()) { %>
    <tr>
        <td>
            <img src="<%= image.getUrl() %>" width="100%" title="<%= image.getDescription() %>"/>
        </td>
    </tr>
    <% }
    } else { %>
    <% List<Image> images = gallery.getImages();
        int size = images.size();
        for (int i = 0; i < (size - (size % 2)); i += 2) { %>
    <tr>
        <td>
            <img src="<%= images.get(i).getUrl() %>" width="100%" title="<%= images.get(i).getDescription() %>"/>
        </td>
        <td>
            <img src="<%= images.get(i+1).getUrl() %>" width="100%" title="<%= images.get(i).getDescription() %>"/>
        </td>
    </tr>
    <% }
        if (size % 2 != 0) { %>
    <tr>
        <td>
            <img src="<%= images.get(size-1).getUrl() %>" width="100%"
                 title="<%= images.get(size-1).getDescription() %>"/>
        </td>
        <td>
        </td>
    </tr>
    <% }
    } %>
</table>
</body>
</html>