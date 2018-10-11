#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    unsigned int numberOfStocks;
    int freeStockNumber;
    int maxPriceOfStocks = 0;

    cin >> numberOfStocks;
    cin >> freeStockNumber;

    vector<int> stocks;
    stocks.reserve(numberOfStocks);


    int currentStock;
    for (int i = 0; i < numberOfStocks; ++i) {
        cin >> currentStock;
        maxPriceOfStocks += currentStock;
        stocks.push_back(currentStock);
    }

    sort(stocks.begin(), stocks.end());

    int startIndex = numberOfStocks % freeStockNumber;

    for (int i = startIndex; i < numberOfStocks; i += freeStockNumber) {
        maxPriceOfStocks -= stocks[i];
    }

    cout << maxPriceOfStocks;

    return 0;
}
