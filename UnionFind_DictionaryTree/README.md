Union find 
合并两个集合/ 
Illustration： 多叉树
Store: 
  Father representation: HashMap/ List -> Represent the Father of each node 
  
  Father["Nokia"] = "Microsoft";
  Father["Instagram"] = "Facebook";
  
Initialization: 
  Father node: Self
  Father["i"] = "i";

Find the Union belong: 
  Find the upper-most father node 

Comnbine the unions: 
  Find the root/ father -> comnbine the 2 father nodes 
  

  
