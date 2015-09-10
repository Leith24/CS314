Name: Gavin Leith
UTEID: gdl386
Comments: none
Answers:
#7) This sort has a big O of O(nlogn) as it keeps breaking the list in halves to put itself in order. The destructive merge sort in class had a O(n^2) as we need to go through two lists to make one new list. However, there is a lot of garbage left over in this sort as each recursion creates 2 new lists for that list put into the function. That means there should be nlogn  garbage created for a list of n objects.
