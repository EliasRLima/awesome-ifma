# Grafos
Implementação e desenvolvimento de grafos para resolução de problemas

1. Apresente a ordem dos vértices visitados, tanto na busca em Largura quanto em Profundidade. Os
dados do grafo, vértices e arestas, obrigatoriamente devem ser lidos de um arquivo txt, bem como o
vértice de origem. Indicar no início do arquivo o que representa cada linha.

4. Dado um grafo, verificar se ele é bipartido ou não.
Um grafo bipartido é um grafo cujos vértices podem ser divididos em dois conjuntos disjuntos
U e V, de modo que cada aresta conecta um vértice em U a um em V. O grafo a seguir é bipartido,
pois é possível dividi-lo em dois conjuntos, com cada aresta tendo um ponto final no conjunto U e o
outro no conjunto V.

Existem duas maneiras de verificar um gráfico bipartido:
a. Um grafo é um grafo bipartido, se e somente se, seu número cromático = 2 e,
obrigatoriamente, os vértices adjacentes são de cores distintas. USAR DFS. A ideia principal é
atribuir a cada vértice uma cor diferente da cor de seu. Se existir uma aresta conectando o vértice
atual a um vértice anterior com a mesma cor, então pode-se afirmar que o grafo não é bipartido.
b. Um grafo é um grafo bipartido se e somente se não contiver um ciclo ímpar. USAR BFS.
Se um grafo contém um ciclo ímpar, não é possível dividir o grafo de forma que cada vértice adjacente
tenha uma cor diferente. Fazendo uma BFS, iniciando no vértice v, se for encontrado uma aresta,
cujos vértices estão no mesmo nível, então o gráfico não é bipartido, e um ciclo ímpar é encontrado.
Neste caso, o nível do vértice é sua distância para vértice inicial v. Em outras palavras, se o vértice já
foi descoberto e o nível dos vértices `u` e` v` são os mesmos, então o gráfico contém um ciclo ímpar
e não é bipartido. Caso um grafo tenha muitos componentes conectados e cada componente for
bipartido, então o grafo é bipartido.
