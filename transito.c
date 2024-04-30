#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>
#include <stdbool.h>
#include <time.h>

pthread_mutex_t mutex;
int turno = 1; //controlar o turno de cada thread

void *transito(void *arg) {
    int id = *(int *)arg;

    srand(time(NULL)); //usa o tempo atual para inicializar 
    int min = 2;
    int max = 10;
    int numeroDeCarrosRua1 = rand() % (max - min + 1) + min;
    int numeroDeCarrosRua2 = rand() % (max - min + 1) + min;//gerando numero aleatorio de carros
    
    while (true) {
        pthread_mutex_lock(&mutex); //a partir de agora vai iniciar a passagem dos carros,
        //por isso bloquamos outras threads
        if (turno == id) {//verifica se esta na vez certa
            printf("Thread %d tem sinal verde\n", id);
            int numCarrosPassando;
            if (id == 1) {
                numCarrosPassando = numeroDeCarrosRua1;
            } else {
                numCarrosPassando = numeroDeCarrosRua2;
            }
            printf("Quantidade de carros na thread %d: %d\n",id, numCarrosPassando);
            int cont = 1;
            while (numCarrosPassando + 1 > cont) {
                printf("Carro %d passando pela thread %d\n", cont, id);
                cont++;
                sleep(1); 
            }
            turno = (turno % 2) + 1;  // muda o turno pra a próxima thread usando logica que alterna entre 1 e 2
            pthread_mutex_unlock(&mutex); // liberar o mutex para a outra thread
        } else {
            pthread_mutex_unlock(&mutex); // se não for a vez, libera mutex
            usleep(50000); 
        }
        break; //versão apenas pra testar o funcionamento
    }

    return NULL;
}

int main() {
    pthread_t t1, t2;
    //t1 controla a segunda rua
    //t2 controla a segunda rua
    pthread_mutex_init(&mutex, NULL);//inicializando mutex

    int id1 = 1;
    int id2 = 2;//vai ser mandando como argumeto para a função transito pra facilitar o controle

    pthread_create(&t1, NULL, transito, &id1); 
    pthread_create(&t2, NULL, transito, &id2); 

    pthread_join(t1, NULL);
    pthread_join(t2, NULL);

    pthread_mutex_destroy(&mutex);

    return 0;
}
