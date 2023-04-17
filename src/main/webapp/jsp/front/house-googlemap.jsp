<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>Map</title>
    <link rel="stylesheet" type="text/css" href="styles/styles.css"/>
</head>

<body>
<style type="text/css">
    #map-area {
        width: 100%;
        height: 100%;
        /*overflow: hidden;*/
        /*margin: 0;*/
        /*position: absolute;*/
        /*padding-bottom: 20px;*/
    }

    html, body {
        height: 100%;
        margin: 0;
        padding: 0;
    }
</style>
<div id="map-area"></div>
<!--note how the script is at the bottom of the page as it has to wait for the DOM to load before any of the map functionality can be applied-->
<script type="text/javascript" src="scripts/map.js"></script>
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyAvKZN-V6xzNr3Vz13AgCHCpdZ5q8qSyRw&callback=initMap" async defer></script>

<script type="text/javascript">
    function AddCustomControl(controlDiv, map) {

        google.maps.event.addDomListener(controlDiv, 'click', function() {

        });
    }


    function initMap() {
        var longitude = ${longitude};
        var latitude = ${latitude};

        var myLatlng = new google.maps.LatLng(longitude, latitude);
        var mapOptions = {
            center: myLatlng,
            zoom: 16,
            mapTypeId: google.maps.MapTypeId.ROADMAP,
            streetViewControl: true,
            overviewMapControl: false,
            rotateControl: false,
            scaleControl: false,
            panControl: false,

        };

        var map = new google.maps.Map(document.getElementById("map-area"),
            mapOptions);

        var customControlDiv = document.createElement('div');
        customControlDiv.id="customControlDiv";
        AddCustomControl(customControlDiv, map);
        map.controls[google.maps.ControlPosition.TOP_RIGHT].push(customControlDiv);


        var marker = new google.maps.Marker({
            position: myLatlng,
            map: map,
            title: "Newcastle"
        });

        marker.setMap(map);

    }
</script>
</body>
</html>