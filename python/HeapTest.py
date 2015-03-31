### Anna Podolny 322152893 ###

import sys
import Heap

h = {}
Adj = {}
test_mode = 1

def main_menu(h):
	ops = [1,2,3,4,5,6,7]
	case = 0
	while case <> 7:
		print "Please enter your choise:"
		print "(1):\tBuild heap"
		print "(2):\tInsert into heap"
		print "(3):\tFind max value"
		print "(4):\tFind min value"
		print "(5):\tDelete max"
		print "(6):\tDelete min"
		print "(7):\tExit"
		
		stdin = sys.stdin.readline()
		case = stdin[0]
		if case == '1':
			i = 1
			h['max'] = ['#']
			h['min'] = ['#']
			h['index_min'] = ['#']
			h['index_max'] = ['#']
			print "Please enter values separated by space, 'Enter' to stop:"
			input = sys.stdin.readline().split()
			for item in input:
				h['max'].append(int(item))
				h['min'].append(int(item))
				h['index_min'].append(i)
				h['index_max'].append(i)
				i+=1
			Heap.build(h)
			print h
		elif case == '2':
			if not h:
				print "Please create heap first"
			else:
				print "Please enter value:"
				stdin = sys.stdin.readline()
				val = int (stdin)
				Heap.insert(h,val)
				print h
		elif case == '3':
			print "Maximum value is: " + str (Heap.find_max(h))
			print h
		elif case == '4':
			print "Minimum value is: " + str (Heap.find_min(h))
			print h
		elif case == '5':
			Heap.delete_max(h)
			print "Maximum value is deleted"
			print h
		elif case == '6':
			Heap.delete_min(h)
			print "Minimum value is deleted"
			print h
		elif case == '7':
			return
		else:
			print "Illigal selection"
			
main_menu(h)	

if test_mode:
	h['max'] = ['#',5,8,10,11,3,2,7,20,12,17,45]
	h['min'] = ['#',5,8,10,11,3,2,7,20,12,17,45]
	h['index_max'] = ['#',1,2,3,4,5,6,7,8,9,10,11]
	h['index_min'] = ['#',1,2,3,4,5,6,7,8,9,10,11]

	#h['max'] = ['#',53,16,17,30,20]
	#h['min'] = []
	#h['index_max'] = ['#',1,2,3,4,5]
	#h['index_min'] = ['#',1,2,3,4,5]
	print "Heap for example:"
	print h
	print "Build heap:"
	Heap.build(h)
	print h
	#Heap.neighbors(h['max'],Adj)
	#Heap.BFS(h['max'][1],Adj)
	print "Find Max:"
	print Heap.find_max(h)
	print "Mind Min:"
	print Heap.find_min(h)
	print "Delete Max:"
	Heap.delete_max(h)
	print h
	print "Delete Min:"
	Heap.delete_min(h)
	print h
	print "Insert 70:"
	Heap.insert(h,70)
	print h
