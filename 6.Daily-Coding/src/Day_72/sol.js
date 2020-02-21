const solution = (aircraftEmissions, flightItineraries, origin, destination) => {
    const emissions = new Map();
    aircraftEmissions.forEach(str => {
        const [aircraft, emission] = str.split('-');
        emissions.set(aircraft, parseFloat(emission));
    });

    let flightFound = false;
    let min = Number.MAX_SAFE_INTEGER;
    flightItineraries.forEach(flight => {
        const [or, dest, distanceStr, model] = flight.split('-');
        if (or === origin && dest === destination) {
            flightFound = true;
            const currentEmissions = emissions.get(model) * parseFloat(distanceStr);
            if (currentEmissions < min) {
                min = currentEmissions;
            }
        }
    });

    return flightFound ? min.toFixed(2) : 0;
};