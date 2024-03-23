def solution(numbers, target):
    tree = [[] for _ in range(len(numbers))]
    tree[0] = [numbers[0],-numbers[0]]
    for i in range(1, len(numbers)):
        
        for j in range(len(tree[i-1])*2):
            if j%2==0:
                tree[i].append(tree[i-1][j//2] + numbers[i])
            else:
                tree[i].append(tree[i-1][j//2] - numbers[i])
    
    answer = sum([t==target for t in tree[-1]])
    return answer
