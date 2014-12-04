var map = L.map('map').setView([43.079, -89.4], 12);
var neighborhoodJSON = L.geoJson(madison, {stype: style, onEachFeature: onEachFeature});
var lastLayer = null;

function onEachFeature(feature, layer){
	//alert(feature.properties.NAME);
	//layer.bindPopup("You've clicked " + feature.properties.NAME);
	if(typeof Android === 'underfined'){
	    layer.on({
	        mouseover: highlightFeature,
	        mouseout: resetHighlight
	    });
	}
    
	layer.on('click', function(e) {
							if(typeof Android != 'undefined'){
								highlightFeature(e);
								if(lastLayer != null){
									resetHighlight(lastLayer);
								}
								lastLayer = e;	
								Android.changeBarContent(feature.properties.NAME, 2);
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
        fillColor: '#ffffff'
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




var neighborhoodJSON = L.geoJson(madison, {style: style, onEachFeature: onEachFeature});

function resetHighlight(e) {
    neighborhoodJSON.resetStyle(e.target);
}

L.marker([43.074374,-89.383656]).addTo(map)
	.bindPopup("<b>Your Old Home!</b><br />Main Street, Madison.").openPopup();
	
	L.tileLayer('https://{s}.tiles.mapbox.com/v3/{id}/{z}/{x}/{y}.png', {
				maxZoom: 18,
				attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a>' +
				 
					' Imagery © <a href="http://mapbox.com">Mapbox</a>',
				id: 'examples.map-i875mjb7'
			}).addTo(map);
	
map.addLayer(neighborhoodJSON);
	