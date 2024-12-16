def solution(cacheSize, cities):
    class LRUCache:
        def __init__(self, cacheSize):
            self.cacheSize = cacheSize
            self.cache = []
            
        def get(self, data):
            if data in self.cache:
                self.cache.remove(data)
                self.cache.append(data)
                return 1
            if len(self.cache) == self.cacheSize:
                if self.cache:
                    self.cache.pop(0)
            if len(self.cache) + 1 <= self.cacheSize:
                self.cache.append(data)
            return 5
                
    LRUcache = LRUCache(cacheSize)
    answer = 0
    for city in cities:
        answer += LRUcache.get(city.lower())
    return answer