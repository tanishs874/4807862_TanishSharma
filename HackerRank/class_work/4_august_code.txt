#include <stdio.h>

int main() {
    int weekday;

    do {
        printf("Please enter a value from 1 to 7 to know the day: ");
        scanf("%d", &weekday);

        if(weekday < 1 || weekday > 7) {
            printf("Oops! That’s not valid. Try a number between 1 and 7.\n");
        }

    } while(weekday < 1 || weekday > 7);

    switch(weekday) {
        case 1:
            printf("It's Monday!\n");
            break;
        case 2:
            printf("It's Tuesday!\n");
            break;
        case 3:
            printf("It's Wednesday!\n");
            break;
        case 4:
            printf("It's Thursday!\n");
            break;
        case 5:
            printf("It's Friday!\n");
            break;
        case 6:
            printf("It's Saturday!\n");
            break;
        case 7:
            printf("It's Sunday!\n");
            break;
    }

    return 0;
}
