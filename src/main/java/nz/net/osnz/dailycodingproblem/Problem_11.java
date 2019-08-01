package nz.net.osnz.dailycodingproblem;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kefeng Deng (deng@51any.com)
 * <p>
 * This problem was asked by Twitter.
 * <p>
 * Implement an autocomplete system. That is, given a query string s and a set of all possible query strings,
 * return all strings in the set that have s as a prefix.
 * <p>
 * For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].
 * <p>
 * Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.
 */
public class Problem_11 {

  class Node {
    Node parent;
    char data;
    boolean isWord;
    Map<Character, Node> children;

    Node(Node parent, char c) {
      this(parent, c, false);
    }

    Node(Node parent, char c, boolean isWord) {
      this.parent = parent;
      this.data = c;
      this.isWord = isWord;
      children = new HashMap<>();
    }

    void addWord(String word) {
      if (word == null || "".equals(word.trim())) {
        return;
      }

      char firstChar = word.charAt(0);
      if (!children.containsKey(firstChar)) {
        children.put(firstChar, new Node(this, firstChar, word.length() == 1));
      }

      if (word.length() > 1) {
        children.get(firstChar).addWord(word.substring(1));
      }

    }

    Node findPrefix(String prefix) {

      if (prefix == null) {
        return null;
      }

      if ("".equals(prefix.trim())) {
        return null;
      }

      if (prefix.length() == 1) {
        return children.get(prefix.charAt(0));
      }

      char firstChar = prefix.charAt(0);
      if (!children.containsKey(firstChar)) {
        return null;
      }

      return children.get(firstChar).findPrefix(prefix.substring(1));
    }

    List<Node> findWordNode() {
      List<Node> result = new ArrayList<>();
      if (this.isWord) {
        result.add(this);
      }
      for (Map.Entry<Character, Node>entry : children.entrySet()) {
        result.addAll(entry.getValue().findWordNode());
      }
      return result;
    }

    String toWord() {
      if (!isWord) {
        return null;
      }
      StringBuilder sb = new StringBuilder();
      sb.append(data);
      Node node = parent;
      while (node != null) {
        sb.append(node.data);
        node = node.parent;
      }
      return sb.reverse().toString().trim();
    }

  }

  class SearchTree {
    Node root;

    SearchTree() {
      this(null);
    }

    SearchTree(String[] words) {
      root = new Node(null, ' ');
      if (words != null) {
        addWord(words);
      }
    }

    void addWord(String[] words) {
      for (String word : words) {
        root.addWord(word);
      }
    }

    String[] search(String prefix) {
      List<String> result = new ArrayList<>();
      Node parentNode = root.findPrefix(prefix);
      if (parentNode != null) {
        List<Node> wordNodes = parentNode.findWordNode();
        for (Node node : wordNodes) {
          result.add(node.toWord());
        }
      }
      return result.toArray(new String[result.size()]);
    }

  }

  @Test
  public void test() {
    String[] input = {"dog", "deer", "deal"};
    SearchTree tree = new SearchTree(input);
    String[] expect = new String[]{"deer", "deal"};
    Assertions.assertArrayEquals(expect, tree.search("de"));
  }


}
