def solution(board,moves):
    moves = [i-1 for i in moves]
    basket=[]
    for i in moves:
        for j in range(len(board)):
            if board[j][i]!=0:
                basket.append(board[j][i])
                board[j][i] = 0
                break
    score=0
    basket_c = basket.copy()
    while True:
        for i in range(len(basket)-1):
            if basket[i]==basket[i+1]:
                basket.pop(i)
                basket.pop(i)
                score+=2
                print(basket)
                break
        if basket_c == basket:
            break
        else:
            basket_c = basket.copy()
    return score
