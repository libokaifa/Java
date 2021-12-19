package com.libo.javalibrary.graph;

/**
 * /**
 *
 * @Author libo
 * @create 2021/12/19 11:36 下午
 * @describe:
 */
public class Dijkstra {
    //节点数目
    protected int size;
    //定义数组，保存顶点信息
    protected String[] nodes;

    //定义矩阵保存顶点信息
    protected int[][] edges;

    private int[] isMarked;//节点确认--中心标识
    private String[] path;//源到节点的路径信息
    private int[] distances;//源到节点的距离

    public Dijkstra(){
        init();

        isMarked = new int[size];
        path = new String[size];
        distances = new int[size];

        for (int i=0;i<size;i++){
            path[i] = "";
            distances[i] = Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.search(3);
    }

    public void search(int node){
        path[node] = nodes[node];
        distances[node] = 0;

        do {
            flushlast(node);
            node = getShort();
        }while (node != -1);
    }

    //1、扫描AA邻接点，记录邻接点权重值
    private void flushlast(int node){
        isMarked[node] = 1;
        System.out.println(path[node]);
        //扫描邻接点
        for (int i=0;i<size;i++){
            if (this.edges[node][i] > 0){
                //计算AA节点到 i节点的权重值
                int distant = distances[node] + this.edges[node][i];
                if (distant < distances[i]){
                    distances[i] = distant;
                    path[i] = path[node] +"-->"+ nodes[i];
                }
            }
        }
    }

    //	2、找出邻接点里最小的那个值
    private int getShort(){
        int last = -1;

        int min = Integer.MAX_VALUE;
        for (int i=0;i<size;i++){

            if (isMarked[i] == 1){
                continue;
            }

            if (distances[i] < min){
                min = distances[i];
                last = i;
            }
        }

        return last;
    }


    public void init(){
        //初始化顶点
        nodes = new String[]{"AA","A","B","C","D","E","F","G","H","M","K","N"};
        //节点编号-常量
        final int AA=0,A=1,B=2,C=3,D=4,E=5,F=6,G=7,H=8,M=9,K=10,N=11;
        size=nodes.length;

        edges = new int[size][size];
        edges[AA][A] = 3;
        edges[AA][B] = 2;
        edges[AA][C] = 5;
        edges[A][AA] = 3;
        edges[A][D] = 4;
        edges[B][AA] = 2;
        edges[B][C] = 2;
        edges[B][G] = 2;
        edges[B][E] = 3;
        edges[C][AA] = 5;
        edges[C][E] = 2;
        edges[C][B] = 2;
        edges[C][F] = 3;
        edges[D][A] = 4;
        edges[D][G] = 1;
        edges[E][B] = 3;
        edges[E][C] = 2;
        edges[E][F] = 2;
        edges[E][K] = 1;
        edges[E][H] = 3;
        edges[E][M] = 1;
        edges[F][C] = 3;
        edges[F][E] = 2;
        edges[F][K] = 4;
        edges[G][B] = 2;
        edges[G][D] = 1;
        edges[G][H] = 2;
        edges[H][G] = 2;
        edges[H][E] = 3;
        edges[K][E] = 1;
        edges[K][F] = 4;
        edges[K][N] = 2;
        edges[M][E] = 1;
        edges[M][N] = 3;
        edges[N][K] = 2;
        edges[N][M] = 3;
    }


}

