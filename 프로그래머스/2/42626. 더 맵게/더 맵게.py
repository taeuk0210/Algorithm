import heapq
    
def solution(scoville, K):
    answer = 0
    heap = []
    for s in scoville:
        heapq.heappush(heap, s)
        
    top1 = heapq.heappop(heap)
    while top1 < K:
        top2 = heapq.heappop(heap)
        heapq.heappush(heap, top1 + top2*2)
        answer += 1
        top1 = heapq.heappop(heap)
        
        if not heap and top1 < K:
            answer = -1
            break
    
    return answer