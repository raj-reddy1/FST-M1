fruit_shop = {
    "apple": 10,
    "banana": 12,
    "orange": 8,
    "peaches": 20
}

key_to_check = input("What are you looking for? ").lower()
"""
if(key_to_check in fruit_shop):
    print("Yes, this is available")
else:
    print("No, this is not available")
"""
if(key_to_check in fruit_shop.values()):
    print("Yes, this is available")
else:
    print("No, this is not available")