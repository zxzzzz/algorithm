package Kruscal;

import java.util.*;

import static javax.swing.UIManager.get;

/**
 * Created by zx on 16-11-5.
 */
//判断是否回路  并查集
public class kruscal {
    static HashSet<Character> hasEdge = new HashSet<>();     //存放已经存在在树里的节点
    static Queue queue = new LinkedList<Edge>();//将所有边加入队列，遍历
    static ArrayList<Edge> edges = new ArrayList<>();

    public static void main(String[] args) {
        Vetrix a=new Vetrix();
        a.setSelf('a');
        Vetrix b =new Vetrix();
        b.setSelf('b');
        Vetrix c=new Vetrix();
        c.setSelf('c');
        Vetrix d=new Vetrix();
        d.setSelf('d');
        Vetrix e=new Vetrix();
        e.setSelf('e');
        Vetrix f=new Vetrix();
        f.setSelf('f');
        Vetrix g=new Vetrix();
        g.setSelf('g');
        Vetrix h=new Vetrix();
        h.setSelf('h');
        Vetrix i=new Vetrix();
        i.setSelf('i');
        ArrayList<Vetrix> vetrices=new ArrayList<>();
        vetrices.add(a);
        vetrices.add(b);
        vetrices.add(c);
        vetrices.add(d);
        vetrices.add(e);
        vetrices.add(f);
        vetrices.add(g);
        vetrices.add(h);
        vetrices.add(i);
        edges.add(new Edge(a, h, 8));
        edges.add(new Edge(h, g, 1));
        edges.add(new Edge(g, f, 2));
        edges.add(new Edge(f, e, 10));
        edges.add(new Edge(e, d, 9));
        edges.add(new Edge(d, c, 7));
        edges.add(new Edge(c, b, 8));
        edges.add(new Edge(b, a, 4));
        edges.add(new Edge(b, h, 11));
        edges.add(new Edge(h, i, 7));
        edges.add(new Edge(i, c, 2));
        edges.add(new Edge(i, g, 6));
        edges.add(new Edge(c, f, 4));
        edges.add(new Edge(f, d, 14));
        solution(edges,vetrices);

    }

    //边类
    static class Edge {
        Vetrix start;//起点
        Vetrix end;//终点
        int value;//权重


        public Edge(Vetrix start, Vetrix end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

    }

    //节点类
    static class Vetrix {
        char self;//节点自身的值
        Vetrix pre;//根节点

        public char getSelf() {
            return self;
        }

        public Vetrix getPre() {
            return pre;
        }

        public void setSelf(char self) {
            this.self = self;
        }

        public void setPre(Vetrix pre) {
            this.pre = pre;
        }

        public boolean equals(Vetrix vetrix) {
           return this.self==vetrix.self;
        }


    }

//并查集

    //返回根节点
    public static Vetrix find(Vetrix vetrix) {

        Vetrix pre = vetrix;
        while (pre.getPre() != pre) {
            pre = pre.getPre();
            System.out.println("pre:"+pre.getSelf());
        }
        return pre;

    }

    //合并子树
    public static void union(Vetrix v1, Vetrix v2) {
        Vetrix v3=find(v1);
        Vetrix v4=find(v2);
        if (v3!=v4)
            v3.setPre(v4);

    }

    public static void solution(ArrayList<Edge> edges,ArrayList<Vetrix> vetrices) {
        //按照权重排序
        ArrayList<Edge> storeEdge = new ArrayList<>();
        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.value - o2.value;
            }
        });
        //初始化 将所有的节点当成独立的连通分量 ，即根节点是自己
        for (int i=0;i<vetrices.size();i++)
            vetrices.get(i).setPre(vetrices.get(i));
        for (int i=0;i<edges.size();i++) {
            System.out.println(" "+edges.get(i).value);
//            Vetrix s1 = edges.get(i).start;
//            Vetrix s2 = edges.get(i).end;
            //如果两个端点都不存在于同一棵树中,合并
            char f1=find(edges.get(i).start).getSelf();
            char f2=find(edges.get(i).end).getSelf();
            if (f1!=f2) {
                union(edges.get(i).start,edges.get(i).end);
                storeEdge.add(edges.get(i));//加入边
                continue;
            } else {
                System.out.println(" " + edges.get(i).start.getSelf() + "  " + edges.get(i).end.getSelf() + "  " + edges.get(i).value + "没加入");
                continue;
            }

        }
        for (Edge edge:storeEdge){
            System.out.println("起点："+edge.start.getSelf()+" 终点："+edge.end.getSelf()+" 权重："+edge.value);
        }
    }
}