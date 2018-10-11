#include <iostream>

using namespace std;

void calculateAnswers(int startHours, int startMinutes, int endHours, int endMinutes, int *array) {
    int answerHours;
    int answerMinutes;

    if (startHours <= endHours) {
        answerHours = endHours - startHours;
    } else {
        answerHours = (24 - startHours) + endHours;
    }

    if (startMinutes > endMinutes) {
        answerMinutes = 60 - (startMinutes - endMinutes);
        answerHours--;
    } else {
        answerMinutes = endMinutes - startMinutes;
    }


    array[0] = answerHours;
    array[1] = answerMinutes;
}

void printMinHours(int hoursMatrix[3][2]) {
    int minHours = hoursMatrix[0][0];
    int minMinutes = hoursMatrix[0][1];

    int currentHours;
    int currentMinutes;

    for (int i = 1; i < 3; ++i) {
        currentHours = hoursMatrix[i][0];
        currentMinutes = hoursMatrix[i][1];

        if (minHours < currentHours) {
            continue;
        }

        if (minHours > currentHours) {
            minHours = currentHours;
            minMinutes = currentMinutes;
            continue;
        }


        //if the hours are equal
        if (minMinutes > currentMinutes) {
            minMinutes = currentMinutes;
        }
    }

    string minHoursString = to_string(minHours);
    string minMinutesString;

    if (minMinutes < 10) {
        minMinutesString = "0";
    }

    minMinutesString += to_string(minMinutes);

    cout << minHoursString << ":" << minMinutesString << endl;
}

void printMaxHours(int hoursMatrix[3][2]) {
    int maxHours = hoursMatrix[0][0];
    int maxMinutes = hoursMatrix[0][1];

    int currentHours;
    int currentMinutes;

    for (int i = 1; i < 3; ++i) {
        currentHours = hoursMatrix[i][0];
        currentMinutes = hoursMatrix[i][1];

        if (maxHours > currentHours) {
            continue;
        }

        if (maxHours < currentHours) {
            maxHours = currentHours;
            maxMinutes = currentMinutes;
            continue;
        }


        //if the hours are equal
        if (maxMinutes < currentMinutes) {
            maxMinutes = currentMinutes;
        }
    }

    string maxHoursString = to_string(maxHours);
    string maxMinutesString;

    if (maxMinutes < 10) {
        maxMinutesString = "0";
    }

    maxMinutesString += to_string(maxMinutes);

    cout << maxHoursString << ":" << maxMinutesString << endl;
}


int main() {
    int hoursMatrix[3][4];
    int answersMatrix[3][2];

    for (int i = 0; i < 3; ++i) {
        cin >> hoursMatrix[i][0];
        cin >> hoursMatrix[i][1];
        cin >> hoursMatrix[i][2];
        cin >> hoursMatrix[i][3];
    }

    for (int i = 0; i < 3; ++i) {
        calculateAnswers(hoursMatrix[i][0], hoursMatrix[i][1], hoursMatrix[i][2], hoursMatrix[i][3], answersMatrix[i]);
    }

    printMinHours(answersMatrix);
    printMaxHours(answersMatrix);

    return 0;
}