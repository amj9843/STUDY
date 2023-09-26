def solution(ingredient):
    ingredients = []
    count = 0
    for num in ingredient:
        ingredients.append(num)
        if ingredients[-4:] == [1, 2, 3, 1]:
            count += 1
            del ingredients[-4:]
            
    return count
