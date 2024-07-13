#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_CURRENCIES 100
#define MAX_NAME_LENGTH 100

typedef struct {
    char name[MAX_NAME_LENGTH];
    double price;
} Currency;

Currency* cryptocurrencies = NULL;
int numCurrencies = 0;
int maxCurrencies = 0;

void addCurrency(const char* name, double price) {
    if (numCurrencies >= maxCurrencies) {
        int newMaxCurrencies = maxCurrencies + 10;
        Currency* newCryptocurrencies = (Currency*)realloc(cryptocurrencies, newMaxCurrencies * sizeof(Currency));
        if (newCryptocurrencies == NULL) {
            printf("Memory allocation failed.\n");
            return;
        }
        cryptocurrencies = newCryptocurrencies;
        maxCurrencies = newMaxCurrencies;
    }

    Currency* currency = &cryptocurrencies[numCurrencies++];
    strncpy(currency->name, name, MAX_NAME_LENGTH);
    currency->price = price;
    printf("", currency->name, currency->price);
}

void displayConversionToCurrency(const char* name, double dollars) {
    Currency* currency = NULL;
    int i;
    for (i = 0; i < numCurrencies; i++) {
        if (strcmp(cryptocurrencies[i].name, name) == 0) {
            currency = &cryptocurrencies[i];
            break;
        }
    }

    if (currency == NULL) {
        printf("Currency not found.\n");
        return;
    }

    double amount = dollars / currency->price;
    printf("%.2f dollars is equivalent to %.2f %s.\n", dollars, amount, currency->name);
}

void convertToDollars() {
    double dollars;
    char currencyName[MAX_NAME_LENGTH];

    printf("Enter the amount in dollars: ");
    scanf("%lf", &dollars);

    printf("Enter the name of the currency: ");
    scanf("%s", currencyName);

    int currencyIndex = -1;
    int i;
    for (i = 0; i < numCurrencies; i++) {
        if (strcmp(cryptocurrencies[i].name, currencyName) == 0) {
            currencyIndex = i;
            break;
        }
    }

    switch (currencyIndex) {
        case -1:
            printf("Currency not found.\n");
            break;
        default:
            displayConversionToCurrency(currencyName, dollars);
            break;
    }
}

void displayCurrencies() {
    printf("Currencies:\n");
    for (int i = 0; i < numCurrencies; i++) {
        Currency* currency = &cryptocurrencies[i];
        printf("%d. %s - Price: %.2f\n", i + 1, currency->name, currency->price);
    }
}

void saveCurrenciesToFile(const char* filename) {
    FILE* file = fopen(filename, "w");
    if (file == NULL) {
        printf("Error opening file.\n");
        return;
    }

    for (int i = 0; i < numCurrencies; i++) {
        Currency* currency = &cryptocurrencies[i];
        fprintf(file, "%s %.2f\n", currency->name, currency->price);
    }

    fclose(file);
    printf("Currencies saved to file '%s'.\n", filename);
}

void loadCurrenciesFromFile(const char* filename) {
    FILE* file = fopen(filename, "r");
    if (file == NULL) {
        printf("Error opening file.\n");
        return;
    }

    char name[MAX_NAME_LENGTH];
    double price;

    while (fscanf(file, "%s %lf", name, &price) == 2) {
        addCurrency(name, price);
    }

    fclose(file);
    printf("Currencies loaded from file '%s'.\n", filename);
}

void freeMemory() {
    free(cryptocurrencies);
}

int main() {
    cryptocurrencies = (Currency*)malloc(10 * sizeof(Currency));
    if (cryptocurrencies == NULL) {
        printf("Memory allocation failed.\n");
        return 1;
    }
    maxCurrencies = 50;

    addCurrency("Bitcoin", 27139.51);
    addCurrency("Ethereum", 1842.77);
    addCurrency("Tether", 1.00);
    addCurrency("BNB", 312.34);
    addCurrency("USD Coin", 0.9999);
    addCurrency("XRP", 0.4625);
    addCurrency("Cardano", 0.3695);
    addCurrency("Dogecoin", 0.07346);
    addCurrency("Polygon", 0.8813);
    addCurrency("Solana", 19.89);
    addCurrency("TRON", 0.08);
    addCurrency("Litecoin", 91.69);
    addCurrency("Polkadot", 5.36);
    addCurrency("Binance USD", 1.00);

    displayCurrencies();

    char currencyName[MAX_NAME_LENGTH];
    double price;

    while (1) {
        printf("Enter the name of the currency to add it (or 'quit' to exit): ");
		fgets(currencyName, sizeof(currencyName), stdin);

		currencyName[strcspn(currencyName, "\n")] = '\0';

		if (strcmp(currencyName, "quit") == 0) {
    	break;
	}


        printf("Enter the price of %s: ", currencyName);
        scanf("%lf", &price);

        addCurrency(currencyName, price);
    }

    displayCurrencies();
    convertToDollars();

    const char* filename = "Final.Project.26900";
    saveCurrenciesToFile(filename);
    freeMemory();
    loadCurrenciesFromFile(filename);
    displayCurrencies();

    return 0;
}
