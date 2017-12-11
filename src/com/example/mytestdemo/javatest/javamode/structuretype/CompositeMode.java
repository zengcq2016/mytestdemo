﻿package com.example.mytestdemo.javatest.javamode.structuretype;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author Zengcq
 * @date 2016年12月14日
 * @version 1.0
 * @description
 * 组合模式有时又叫部分-整体模式在处理类似树形结构的问题时比较方便
 */
public class CompositeMode {
	TreeNode root = null;  
	  
    public CompositeMode(String name) {  
        root = new TreeNode(name);  
    }  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompositeMode tree = new CompositeMode("A");  
        TreeNode nodeB = new TreeNode("B");  
        TreeNode nodeC = new TreeNode("C");  
          
        nodeB.add(nodeC);  
        tree.root.add(nodeB);  
        System.out.println("build the tree finished!"); 
	}

}
class TreeNode {  
    
    private String name;  
    private TreeNode parent;  
    private Vector<TreeNode> children = new Vector<TreeNode>();  
      
    public TreeNode(String name){  
        this.name = name;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public TreeNode getParent() {  
        return parent;  
    }  
  
    public void setParent(TreeNode parent) {  
        this.parent = parent;  
    }  
      
    //添加孩子节点  
    public void add(TreeNode node){  
        children.add(node);  
    }  
      
    //删除孩子节点  
    public void remove(TreeNode node){  
        children.remove(node);  
    }  
      
    //取得孩子节点  
    public Enumeration<TreeNode> getChildren(){  
        return children.elements();  
    }  
}  