class Solution {
    public boolean isAnagram(String s, String t) {
if(s.length()!=t.length())
{
    return false;
}
else
{
Map<Character,Integer> counter =new HashMap<>();
    for(int i=0;i<s.length();i++)
    {
      Character ch=  s.charAt(i);
        counter.put(ch,counter.getOrDefault(ch,0)+1);
    }
     for(int i=0;i<t.length();i++)
    {
        Character ch=  t.charAt(i);
      if(!counter.containsKey(ch) || counter.get(ch)==0)
      {
        return false;
      }
      counter.put(ch, counter.get(ch)-1);
    }
}
return true;
    }
}
