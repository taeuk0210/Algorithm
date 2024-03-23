def solution(alp, cop, problems):
    max_alp = sorted(problems, key=lambda x : x[0], reverse=True)[0][0]
    max_cop = sorted(problems, key=lambda x : x[1], reverse=True)[0][1]
    dp = [[99999]*(max_cop+1) for _ in range(max_alp+1)]

    alp = min(alp, max_alp)
    cop = min(cop, max_cop)
    dp[alp][cop] = 0
    
    for i in range(alp, max_alp+1):
        for j in range(cop, max_cop+1):
            if i < max_alp:
                dp[i+1][j] = min(dp[i+1][j], dp[i][j]+1)
            if j < max_cop:
                dp[i][j+1] = min(dp[i][j+1], dp[i][j]+1)
            
            for alp_req, cop_req, alp_rwd, cop_rwd, cost in problems:
                if i >= alp_req and j >= cop_req:
                    new_alp = min(i+alp_rwd, max_alp)
                    new_cop = min(j+cop_rwd, max_cop)
                    dp[new_alp][new_cop] = min(dp[new_alp][new_cop], dp[i][j]+cost)

    return dp[max_alp][max_cop]