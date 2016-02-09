$(document)
		.ready(
				function() {
					var jsonT = [];
					$
							.ajax({
								type : "GET",
								url : '/list',
								success : function(data) {
									// debugger;
									console.log(data);
									jsonT = JSON.parse(data);
									console.log(jsonT.length);
									
									var tr;
									$("#table tr").remove();
									
									for (var i = 0; i < jsonT.length; i++) {
										tr = $('<tr/>');
										tr.append("<td>" + jsonT[i].name
												+ "</td>");
										tr.append("<td>" + jsonT[i].rating
												+ "</td>");
										tr
												.append("<td><a target='iframe_a' href='https://www.google.com/maps/embed/v1/place?q="
														+ jsonT[i].latitude
														+ ","
														+ jsonT[i].longitude
														+ "%20&zoom=17%20&key=AIzaSyAR9ZztwAvbs89Ypf2RXgl0ynFRV8azbY4'>"
														+ "map" + "</a></td>")
										$('table').append(tr);
									}
								},
								error : function() {
									alert('Error!!');
								}
							});
				});

$(function() {
	$('input')
			.on(
					'click',
					function() {
						
						var text = $('#name').val();		
						$.ajax({
									type : "GET",
									url : '/search/'+text,
									success : function(data) {
										// debugger;
										console.log(data);
										jsonT = JSON.parse(data);
										console.log(jsonT.length);
										var tr;
$("#table tr").remove();

										for (var i = 0; i < jsonT.length; i++) {
											tr = $('<tr/>');
											tr.append("<td>" + jsonT[i].name
													+ "</td>");
											tr.append("<td>" + jsonT[i].rating
													+ "</td>");
											tr
													.append("<td><a target='iframe_a' href='https://www.google.com/maps/embed/v1/place?q="
															+ jsonT[i].latitude
															+ ","
															+ jsonT[i].longitude
															+ "%20&zoom=17%20&key=AIzaSyAR9ZztwAvbs89Ypf2RXgl0ynFRV8azbY4'>"
															+ "map"
															+ "</a></td>")
											$('table').append(tr);
										}
									},
									error : function() {
										alert('Error!!');
									}
								});
					});
});
