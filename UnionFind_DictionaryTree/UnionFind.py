
Def init(self, n): 
  def.father = {} 
  for i in range(): 
  father(i) = i;

## In order to find the Big Brother node in O(1): 路径压缩 
# No need to know the detailed path, 
# for node1, only need to know : 1. 1 upper; 2. Root Node 数据结构扁平化

# Method1 Recursion: 
def find(self, node): 
  if node == seld.father[node]: 
    return node

  self.father[node] = self.find(self.father[node]) 
  return self.father[node]

# Method2, non-recursion: 
def find(self, node): 
  path = [] 
  while self.father[node] != node: 
    node = self.father[node]

  for n in path: 
    self.father[n] = node 
  
  return node
  
  
## Time Complexity 
