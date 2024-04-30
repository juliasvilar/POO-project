#include <stdio.h>
#include <stdlib.h>
#define TRUE 1
#define FALSE 0

typedef struct NoLDE{
    int num;
    struct NoLDE* ant;
    struct NoLDE* prox;
} TNoLDE;

typedef struct LDE{
    TNoLDE* inicio;
    TNoLDE* fim;
    int qtd;
} PontLDE;

void inicializar(PontLDE* lista){
    lista->inicio = NULL;
    lista->fim = NULL;
    lista->qtd = 0;
}

int isEmpty(PontLDE* lista){
    if (lista->qtd == 0){
        return TRUE;
    } else {
        return FALSE;
    }
}

void exibir(PontLDE* lista){
    TNoLDE* aux = lista->inicio;
    while(aux != NULL){
        printf("[%d] ",aux->num);
        aux = aux->prox;
    }
    printf("\n");
}

void inserir(PontLDE* lista){
    int valor;
    printf("Valor: ");
    scanf("%d",&valor);
    TNoLDE* novo = (TNoLDE*)malloc(sizeof(TNoLDE));
    if (isEmpty(lista) == TRUE){ // lista vazia, insere no inicio e final ao mesmo tempo
        novo->num = valor;
        novo->ant = NULL;
        novo->prox = NULL;
        lista->inicio = novo;
        lista->fim = novo;
        lista->qtd = 1;
    } else { // nao vazia, insere sempre no final, nao eh ordenada
        novo->num = valor;
        lista->fim->prox = novo;
        novo->ant = lista->fim;
        lista->fim = novo;
        novo->prox = NULL;
        lista->qtd++;
    }
}


void multiplicar(PontLDE* lista1, PontLDE* lista2, PontLDE* listaProduto){
    TNoLDE* aux1 = lista1->inicio;
    TNoLDE* aux2 = lista2->inicio;
    while (aux1 != NULL && aux2 != NULL){
        TNoLDE* novoProduto = (TNoLDE*)malloc(sizeof(TNoLDE));
        if (isEmpty(listaProduto) == TRUE){ // primeiro elemento listaProduto
            novoProduto->num = aux1->num * aux2->num;
            novoProduto->ant = NULL;
            novoProduto->prox = NULL;
            listaProduto->inicio = novoProduto;
            listaProduto->fim = novoProduto;
            listaProduto->qtd = 1;
        } else {
            
            if(aux1 != NULL && aux2 != NULL){
                novoProduto->num = aux1->num * aux2->num;
                listaProduto->fim->prox = novoProduto;
                novoProduto->ant = listaProduto->fim;
                novoProduto->prox = NULL;
                listaProduto->fim = novoProduto;
                listaProduto->qtd++;
                printf("[%d] ",novoProduto->num);
            } else if (aux1 == NULL && aux2 != NULL){
                novoProduto->num = aux2->num;
                listaProduto->fim->prox = novoProduto;
                novoProduto->ant = listaProduto->fim;
                novoProduto->prox = NULL;
                listaProduto->fim = novoProduto;
                listaProduto->qtd++;
                printf("[%d] ",aux2->num);
            } else if (aux1 != NULL && aux2 == NULL){
                novoProduto->num = aux1->num;
                listaProduto->fim->prox = novoProduto;
                novoProduto->ant = listaProduto->fim;
                novoProduto->prox = NULL;
                listaProduto->fim = novoProduto;
                listaProduto->qtd++;
                printf("[%d] ",aux1->num);
            }
        }
        
        aux2 = aux2->prox;
        aux1 = aux1->prox;
    }
    free(aux1);
    free(aux2);
}


int main(){
    PontLDE lista1, lista2, listaProduto;
    inicializar(&lista1);
    inicializar(&lista2);
    inicializar(&listaProduto);

    int tam;
    printf("\nQuantidade de valores na lista 1: ");
    scanf("%d",&tam);
    for(int i = 0; i < tam; i++){
        inserir(&lista1);
    }

    exibir(&lista1);

    printf("\nQuantidade de valores na lista 2: ");
    scanf("%d",&tam);
    for(int i = 0; i < tam; i++){
        inserir(&lista2);
    }

    exibir(&lista2);

    multiplicar(&lista1,&lista2,&listaProduto);
    printf("Lista produto:\n");

    return 0;
}