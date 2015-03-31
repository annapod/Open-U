### Anna Podolny 322152893 ###

#breadth first search implementation, in order to print heap, level by level
def BFS (s, Adj):
		level = {s:0}
		parent = {s, None}
		i = 1
		frontier = [s]
		while frontier:
			next = []
			for u in frontier:
				for v in Adj[u]:
					if v:
						if v not in level:
							level[v] = i
							#parent[v] = u
							next.append(v)
			frontier = next
			i+=1
		j = 0
		while j <= i:
			for l in level:
				if level[l] == j:
					print l,
			print
			j+=1

#function finds "sons" for each "parent", used in breadth firts search
def neighbors(list,Adj):
	size = len(list) -1
	i = 1
	while i <= size:
		elem = list[i]
		sons = []
		if (i*2 > size):
			sons.append(None)
		else:
			sons.append(list[i*2])
		if (i*2+1 > size):
			sons.append(None)
		else:
			sons.append(list[i*2+1])
		Adj[elem] = sons
		i+=1

def max_heapify(h,i):
	left = i*2
	right = i*2 + 1
	size = len(h['max']) - 1
	max = 0
	temp = 0
	min_ind = 0
	max_ind = 0
	if left <= size and h['max'][left] > h['max'][i]:
		max = left
	else:
		max = i
	if right <= size and h['max'][right] > h['max'][max]:
		max = right
	if max <> i:
		temp = h['max'][i]
		min_ind = h['index_min'][i]

		h['max'][i] = h['max'][max]
		h['index_min'][i] = h['index_min'][max] #ok
		h['max'][max] = temp
		h['index_min'][max] = min_ind

		min_ind = i
		h['index_max'][h['index_min'][max]] = max
		h['index_max'][h['index_min'][i]] = i

		max_heapify(h,max)

def min_heapify(h,i):
	left = i*2
	right = i*2 + 1
	size = len(h['min']) - 1
	min = 0
	temp = 0
	max_ind = 0
	min_ind = 0
	if left <= size and h['min'][left] < h['min'][i]:
		min = left
	else:
		min = i
	if right <= size and h['min'][right] < h['min'][min]:
		min = right
	if min <> i:
		temp = h['min'][i]
		max_ind = h['index_max'][i]
		h['min'][i] = h['min'][min]
		h['index_max'][i] = h['index_max'][min] #ok
		h['min'][min] = temp
		h['index_max'][min] = max_ind

		min_ind = i
		h['index_min'][h['index_max'][min]] = min
		h['index_min'][h['index_max'][i]] = i

		min_heapify(h,min)
	

	
#function build max heap
def build_max_heap(h):
	size = len(h['max']) - 1
	i = size/2 
	while i > 0:
		max_heapify(h,i)
		i-=1
#heap sort, implemented, not used
def heap_sort_max(h):
	size = len(h['max']) - 1
	temp = 0
	build_max_heap(h)
	i = size
	while size >= 2:
		temp = h['max'][0]
		h['max'][0] = h['max'][i]
		h['max'][i] = temp
		i-=1

#function builds min heap
def build_min_heap(h):
	size = len(h['min']) - 1
	i = size/2 
	while i > 0:
		min_heapify(h,i)
		i-=1

#heap sort, implemented, not used
def heap_sort_min(h):
	size = len(h['min']) - 1
	temp = 0
	build_min_heap(h)
	i = size
	while size >= 2:
		temp = h['min'][0]
		h['min'][0] = h['min'][i]
		h['min'][i] = temp
		i-=1

#function deletes first value in min heap and corresponding value in max heap
def delete_max(h):
	size = len (h['max']) - 1
	if size < 1:
		return "Error, heap underflow"
	#delete max from max heap
	max = h['max'][1]
	index_in_min = h['index_min'][1]
	h['max'][1] = h['max'][size]
	h['index_min'][1] = h['index_min'][size]
	h['index_max'][h['index_min'][1]] = h['index_max'][index_in_min]
	h['max'].pop()
	h['index_min'].pop()
	#delete max from min heap
	h['min'][index_in_min] = h['min'][size]
	h['index_max'][index_in_min] = h['index_max'][size]
	if index_in_min <= size -1:
		h['index_min'][h['index_max'][index_in_min]] = index_in_min
	h['min'].pop()
	h['index_max'].pop()

	max_heapify(h,1)
	if index_in_min <= size -1:
		min_heapify(h,index_in_min)
	return max

#function deletes first value in max heap and corresponding value in min heap
def delete_min(h):
	size = len (h['min']) - 1
	if size < 1:
		return "Error, heap underflow"
	#delete max from max heap
	min = h['min'][1]
	index_in_max = h['index_max'][1]
	h['min'][1] = h['min'][size]
	h['index_max'][1] = h['index_max'][size]
	#h['index_min'][1] = h['index_min'][index_in_max]
	h['index_min'][h['index_max'][1]] = h['index_min'][index_in_max]
	h['min'].pop()
	h['index_max'].pop()

	#delete in max
	h['max'][index_in_max] = h['max'][size]
	h['index_min'][index_in_max] = h['index_min'][size]
	if index_in_max <= size -1:
		h['index_max'][h['index_min'][index_in_max]] = index_in_max
	h['max'].pop()
	h['index_min'].pop()

	min_heapify(h,1)
	if index_in_max <= size -1:
		max_heapify(h,index_in_max)
	return min

#function checks if there is a parent smaller than last leaf that was added, switch if needed
def max_insert(h,key,i):
	while i > 1 and h['max'][i/2] < h['max'][i]:
		tmp = h['max'][i]
		h['max'][i] = h['max'][i/2]
		h['max'][i/2] = tmp
		#update_index
		min_ind = h['index_min'][i/2]
		h['index_min'][i/2] = h['index_min'][i]
		h['index_min'][i] = min_ind
		h['index_max'][h['index_min'][i/2]] = i/2
		h['index_max'][h['index_min'][i]] = i
		i = i/2

#function checks if there is a parent bigger than last leaf that was added, switch if needed
def min_insert(h,key,i):
	while i > 1 and h['min'][i/2] > h['min'][i]:
		tmp = h['min'][i]
		h['min'][i] = h['min'][i/2]
		h['min'][i/2] = tmp
		#update index
		max_ind = h['index_max'][i/2]
		h['index_max'][i/2] = h['index_max'][i]
		h['index_max'][i] = max_ind
		h['index_min'][h['index_max'][i/2]] = i/2
		h['index_min'][h['index_max'][i]] = i
		i = i/2

#function inserts value into two heaps: minimu and maximum
def insert(h,key):
	size = len(h['max'])
	h['index_min'].append(size)
	h['index_max'].append(size)
	h['min'].append(key)
	h['max'].append(key)
	max_insert(h,key,size)
	min_insert(h,key,size)

#function finds maximum value in the tree
def find_max(h):
	return h['max'][1]

#function finds minimum value in the tree
def find_min(h):
	return h['min'][1]

#function builds two heaps: minimum and maximum
def build(h):
	build_min_heap(h)
	build_max_heap(h)
