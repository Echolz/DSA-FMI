#include <iostream>
#include <string>

using namespace std;

struct time {
    int hours{};
    int minutes{};
};

typedef time time;

string printMinutes(int minutes) {
    string answer = "";

    if (minutes < 10) {
        answer += "0";
    }

    answer += to_string(minutes);

    return answer;
}

time getTime(int startHours, int startMinutes, int endHours, int endMinutes) {
    time answer{};

    if (startHours <= endHours) {
        answer.hours = endHours - startHours;
    } else {
        answer.hours = (24 - startHours) + endHours;
    }

    if (startMinutes > endMinutes) {
        answer.minutes = 60 - (startMinutes - endMinutes);
        answer.hours--;
    } else {
        answer.minutes = endMinutes - startMinutes;
    }

    return answer;
}

time getMaxTime(time timeArray[]) {
    time answer;

    answer.hours = timeArray[0].hours;
    answer.minutes = timeArray[0].minutes;

    for (int i = 1; i < 3; ++i) {
        if (answer.hours > timeArray[i].hours) {
            continue;
        }

        if (answer.minutes >= timeArray[i].minutes) {
            continue;
        }

        answer.hours = timeArray[i].hours;
        answer.minutes = timeArray[i].minutes;
    }

    return answer;
}

time getMinTime(time timesArray[]) {
    time answer{};

    answer.hours = timesArray[0].hours;
    answer.minutes = timesArray[0].minutes;

    for (int i = 1; i < 3; i++) {
        if (answer.hours < timesArray[i].hours) {
            continue;
        }

        if (answer.minutes <= timesArray[i].minutes) {
            continue;
        }

        answer.hours = timesArray[i].hours;
        answer.minutes = timesArray[i].minutes;
    }

    return answer;
}

int main() {

    int matrix[3][4];

    for (int i = 0; i < 3; i++) {
        cin >> matrix[i][0];
        cin >> matrix[i][1];
        cin >> matrix[i][2];
        cin >> matrix[i][3];
    }

    time timesArray[3];

    for (int i = 0; i < 3; i++) {
        timesArray[i] = getTime(matrix[i][0], matrix[i][1], matrix[i][2], matrix[i][3]);
    }

    time answer = getMinTime(timesArray);
    time answer2 = getMaxTime(timesArray);

    cout << answer.hours << ":" << printMinutes(answer.minutes);

    cout << endl;

    cout << answer2.hours << ":" << printMinutes(answer2.minutes);

    return 0;
}