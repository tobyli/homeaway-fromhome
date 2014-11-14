var map = L.map('map').setView([44.97123, -93.26968], 12);
var neighborhoodJSON = L.geoJson(mpls, {stype: style, onEachFeature: onEachFeature});

function onEachFeature(feature, layer){
	//alert(feature.properties.NAME);
	//layer.bindPopup("You've clicked " + feature.properties.NAME);
	layer.on('click', function(e) {L.popup()
							.setLatLng(e.latlng)
							.setContent(feature.properties.NAME)
							.openOn(map);
							if(typeof Android != 'undefined'){
								Android.changeBarContent(feature.properties.NAME);
							}
						});
}
function style(feature){
	var name = feature.properties.NAME;
    return {
        weight: 1,
        color: '#000000',
        opacity: 0.5,
        fillOpacity: 0.7,
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
var neighborhoodJSON = L.geoJson(mpls, {style: style, onEachFeature: onEachFeature});


L.marker([44.97123, -93.26968]).addTo(map)
	.bindPopup("<b>Hello world!</b><br />Minneapolis.").openPopup();
	
	L.tileLayer('https://{s}.tiles.mapbox.com/v3/{id}/{z}/{x}/{y}.png', {
				maxZoom: 18,
				attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a>' +
				 
					' Imagery © <a href="http://mapbox.com">Mapbox</a>',
				id: 'examples.map-i875mjb7'
			}).addTo(map);
	
map.addLayer(neighborhoodJSON);
	