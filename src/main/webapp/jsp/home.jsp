<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <script type="text/javascript" src="${appLocation}resources/js/jquery.js"></script>
        <script type="text/javascript" src="${appLocation}resources/js/api.core.js"></script>
        <link rel="stylesheet" href="${appLocation}resources/css/application.css" />
        <script type="text/javascript">
        var apiLocation, appBase;
        apiLocation = "${apiLocation}";
        appBase = "${appLocation}";
        
        var showAllTheSamples = function(data) {
            for (var row in data) {
                var icon = data[row].icon;
                var name = data[row].name;
                var row = $('<div>')
                    .addClass("row");
                var nameSpan = $('<span>')
                    .text(name)
                    .addClass('name');
                var img = $('<img />')
                    .prop('src', icon + "&size=40x40")
                $(nameSpan).appendTo(row);
                $(img).appendTo(row);
                $(row).appendTo($('body'));
            }
        }
        var api = new HeroCloneApi(apiLocation);
        $(document).ready(function() {
            api.makeCall("getSamples", null, showAllTheSamples);
        });
        </script>
    </head>
    <body> 
    </body>
</html>