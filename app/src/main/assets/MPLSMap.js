var map = L.map('map').setView([44.97123, -93.26968], 12);
var neighborhoodJSON = L.geoJson(mpls, {style: style, onEachFeature: onEachFeature});
var neighborhoodJSONClose = L.geoJson(mpls, {style: styleClose, onEachFeature: onEachFeature});
var mplsPOIJSON = L.geoJson(mplsPOI, {onEachFeature: onEachFeaturePOI});
var lastLayer = null;
var currentSelectedFeature = null;
var targetMarker;


map.on('zoomend', function(){
    if(map.getZoom() >= 15){

		if(lastLayer != null){
			resetHighlight(lastLayer);
		}
		map.removeLayer(neighborhoodJSON);
		map.removeLayer(targetMarker);
		map.addLayer(neighborhoodJSONClose);
		map.addLayer(mplsPOIJSON);
		

    }
    if(map.getZoom() < 15){

		if(lastLayer != null){
			highlightFeature(lastLayer);
		}
		map.removeLayer(neighborhoodJSONClose);
		map.removeLayer(mplsPOIJSON);
		map.addLayer(neighborhoodJSON);
		map.addLayer(targetMarker);
    }

});

function zoomDetail(){
	alert("zoom detail");
	var coordinate;
	if(currentSelectedFeature == null){
		coordinate = [44.949006,-93.300031];
	}
	else{
		coordinate = [currentSelectedFeature.latlng.lat, currentSelectedFeature.latlng.lng];		
	}
	map.setView(coordinate, 16);
}

function onEachFeature(feature, layer){
	//alert(feature.properties.NAME);
	//layer.bindPopup("You've clicked " + feature.properties.NAME);
	if(typeof Android === 'underfined'){
	  
	}
    
	layer.on('click', function(e) {
							if(typeof Android != 'undefined'){
								highlightFeature(e);
								currentSelectedFeature = e;
								if(lastLayer != null){
									resetHighlight(lastLayer);
								}
								lastLayer = e;	
								Android.changeBarContent(feature.properties.NAME, 0);
							}
							else{
								L.popup().setLatLng(e.latlng).setContent(feature.properties.NAME).openOn(map);								
							}
						});

							
}

function onEachFeaturePOI(feature, layer){
	//alert(feature.properties.NAME);
	//layer.bindPopup("You've clicked " + feature.properties.NAME);
	if(typeof Android === 'underfined'){
	  
	}
    
	layer.on('click', function(e) {
							if(typeof Android != 'undefined'){									
								Android.changeBarContent(feature.properties.NAME, 1);
							}
							else{
								L.popup().setLatLng(e.latlng).setContent(feature.properties.NAME).openOn(map);								
							}
						});

						
}
function style(feature){
	var name = feature.properties.NAME;
    return {
        weight: 1,
        color: '#000000',
        opacity: 0.5,
        fillOpacity: 0.5,
        fillColor: getColor(name)
    };
	
}

function styleClose(feature){
	var name = feature.properties.NAME;
    return {
        weight: 3,
        color: '#000000',
        opacity: 0.5,
        fillOpacity: 0.15,
        fillColor: getColor(name)
    };
	
}

function getColor(name) {
    if(nameColorMap[name] == undefined){
        return '#ffffff';
    }
	else{
		return nameColorMap[name];
	}
	
}

function highlightFeature(e) {
    var layer = e.target;

    layer.setStyle({
        weight: 8,
        opacity: 1,
        color: '#09F',
        dashArray: '3'

    });

}





function resetHighlight(e) {
    neighborhoodJSON.resetStyle(e.target);
}

targetMarker = L.marker([44.949006,-93.300031])
	.bindPopup("<b>Most Similar!</b><br />Uptown Minneapolis.").openPopup();
	targetMarker.addTo(map);
	
	L.tileLayer('https://{s}.tiles.mapbox.com/v3/{id}/{z}/{x}/{y}.png', {
				maxZoom: 18,
				attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a>' +
				 
					' Imagery © <a href="http://mapbox.com">Mapbox</a>',
				id: 'examples.map-i875mjb7'
			}).addTo(map);
	
map.addLayer(neighborhoodJSON);
	