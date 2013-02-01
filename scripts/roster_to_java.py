names = [line.strip() for line in open('roster.txt').readlines() if line.strip()]
names = sorted(names)

p = '['
for name in names:
    p += '"'
    p += name
    p += '"'
    p += ', '
p = p[:-2]
p += ']'
print p

print len(names)
