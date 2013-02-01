names = [line.strip() for line in open('roster.txt').readlines() if line.strip()]
names = sorted(names)

p = ''
for name in names:
    p += 'R.drawable.'
    p += name
    p += ', '
p = p[:-2]
print p

print len(names)
