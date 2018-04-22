function getWeather() {
    var x = document.getElementById('weather');
    let locationZipCode = x.value;
    console.log(locationZipCode);
    let request = new XMLHttpRequest();
    return new Promise(function (resolve, reject) {
        let url_header = "http://api.wunderground.com/api/6edf9621eab3f362/forecast/q/CA/";
        let url_tail = ".json";
        let url = url_header + locationZipCode + url_tail;
        if (locationZipCode.length != 5 || isNaN(locationZipCode)) {
            reject("zip code is not proper");
        }
        request.onreadystatechange = () => {
            if (request.readyState === 4) {
                if (request.status === 200) {
                    resolve(request.response);
                }
                else {
                    reject(request.status);
                }
            }
        }
        request.open('GET', url);
        request.send();
    });
}

function deleteNodes() {
    console.log("removing ---");
    var d = document.getElementById('weather_condition');
    while (d.firstChild) {
        d.removeChild(d.firstChild);
    }
}

var clickWeather = function () {
    getWeather().then((response) => {

        let high_f = JSON.parse(response)["forecast"]["simpleforecast"]["forecastday"][0]["high"]["fahrenheit"];
        let high_c = JSON.parse(response)["forecast"]["simpleforecast"]["forecastday"][0]["high"]["celsius"];
        let low_f = JSON.parse(response)["forecast"]["simpleforecast"]["forecastday"][0]["low"]["fahrenheit"];
        let low_c = JSON.parse(response)["forecast"]["simpleforecast"]["forecastday"][0]["low"]["celsius"];
        let condition = JSON.parse(response)["forecast"]["simpleforecast"]["forecastday"][0]["conditions"];

        console.log(high_c + " " + high_f);
        console.log(low_c + " " + low_f);
        console.log(condition);

        deleteNodes();

        $('#weather_condition').append(`<p><b>Highest Temperature: </b> ${high_c}<b>C</b> / ${high_f}<b>F</b></p>`);
        $('#weather_condition').append(`<p><b>Lowest Temperature: </b> ${low_c}<b>C</b> / ${low_f}<b>F</b></p>`);
        $('#weather_condition').append(`<p><b>Current Conditions: </b> ${condition}`);
    }).catch((response) => {
        deleteNodes();
        $('#weather_condition').append(`<p>Error: ${response}</p>`);
    })
}







